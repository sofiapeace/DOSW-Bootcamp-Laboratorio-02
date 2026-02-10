package edu.dosw.lab.comportamiento.Reto4;

import java.util.*;
import java.util.stream.Collectors;

/**
 * PATRÓN DE COMPORTAMIENTO: Strategy
 * Se utiliza para definir diferentes algoritmos de conversión 
 * que son seleccionados dinámicamente.
 */
class Conversor {
    // Tasas de cambio reales aproximadas a 2026 (Base 1 USD)
    private static final Map<String, Double> TASAS_A_USD = Map.of(
        "USD", 1.0,
        "EUR", 1.08,
        "JPY", 0.0066,
        "COP", 0.00025
    );

    public static double realizarConversion(double monto, String origen, String destino) {
        if (!TASAS_A_USD.containsKey(origen) || !TASAS_A_USD.containsKey(destino)) {
            return 0;
        }
        // Lógica: Monto Origen -> USD -> Monto Destino
        double montoEnUSD = monto * TASAS_A_USD.get(origen);
        return montoEnUSD / TASAS_A_USD.get(destino);
    }
}

/**
 * Representa una transacción individual con sus conversiones.
 */
class Transaccion {
    private String monedaOrigen;
    private double montoOrigen;
    private Map<String, Double> conversiones = new HashMap<>();

    public Transaccion(double monto, String origen) {
        this.montoOrigen = monto;
        this.monedaOrigen = origen;
    }

    public void agregarConversion(String destino, double montoConvertido) {
        conversiones.put(destino, montoConvertido);
    }

    public String getMonedaOrigen() { return monedaOrigen; }
    public double getMontoOrigen() { return montoOrigen; }
    public Map<String, Double> getConversiones() { return conversiones; }
}

/**
 * CLASE PRINCIPAL DEL RETO #4
 */
public class Reto4 {
    public static void ejecutar() {
        // useLocale(Locale.US) para que el Scanner acepte puntos decimales (.)
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        List<Transaccion> historial = new ArrayList<>();

        System.out.print("Ingrese número de transacciones: ");
        int n = 0;
        
        if (sc.hasNextInt()) {
            n = sc.nextInt();
        } else {
            System.out.println("Error: Debe ingresar un número entero.");
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println("\nTransacción " + i + "");
            
            System.out.print("Ingrese monto: ");
            double monto = sc.nextDouble();
            
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String origen = sc.next().toUpperCase();
            
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String destinosRaw = sc.next().toUpperCase();
            
            // Consumimos el salto de línea para que no afecte la siguiente transacción
            sc.nextLine(); 

            String[] destinos = destinosRaw.split(",");
            Transaccion t = new Transaccion(monto, origen);

            for (String d : destinos) {
                String monedaDestino = d.trim(); // Limpia espacios accidentales
                double resultado = Conversor.realizarConversion(monto, origen, monedaDestino);
                t.agregarConversion(monedaDestino, resultado);
            }
            historial.add(t);
        }

        // SALIDA DE DATOS
        System.out.println("           RESUMEN DE CAJA TOTAL        ");

        historial.forEach(t -> {
            System.out.printf("\nTransacción Original: %.2f %s\n", t.getMontoOrigen(), t.getMonedaOrigen());
            t.getConversiones().forEach((moneda, valor) -> 
                System.out.printf("  -> Convertido a %s: %.2f %s\n", moneda, valor, moneda));
        });

        // TOTALES USANDO STREAMS 
        System.out.println("\nTOTALES POR MONEDA");
        
        Map<String, Double> totales = historial.stream()
            .flatMap(t -> t.getConversiones().entrySet().stream())
            .collect(Collectors.groupingBy(
                Map.Entry::getKey,
                Collectors.summingDouble(Map.Entry::getValue)
            ));

        totales.forEach((moneda, total) -> 
            System.out.printf("%s: %.2f %s\n", moneda, total, moneda));

        System.out.println("\n¡Servicio finalizado con éxito!");
    }
}