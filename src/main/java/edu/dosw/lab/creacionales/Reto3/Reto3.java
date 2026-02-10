package edu.dosw.lab.creacionales.Reto3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Interface o Clase Base para los productos
 */
abstract class Vehiculo {
    protected String tipo;
    protected String categoria;
    protected int velocidadMaxima;
    protected double precio;
    protected String equipamiento;

    public String getTipo() { return tipo; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("Tipo: %s\nCategoría: %s\nVelocidad máxima: %d km/h\nPrecio: $%.0f\nEquipamiento: %s",
                tipo, categoria, velocidadMaxima, precio, equipamiento);
    }
}

/**
 * Implementación concreta que la fábrica construye
 */
class VehiculoConcreto extends Vehiculo {
    public VehiculoConcreto(String tipo, String categoria) {
        this.tipo = tipo;
        this.categoria = categoria;
        configurarEspecificaciones();
    }

    private void configurarEspecificaciones() {
        // Lógica para asignar valores según la categoría
        switch (categoria.toLowerCase()) {
            case "lujo" -> {
                this.velocidadMaxima = 180;
                this.precio = 50000000;
                this.equipamiento = "Aire acondicionado + GPS + Asientos de cuero";
            }
            case "económico", "economico" -> {
                this.velocidadMaxima = 120;
                this.precio = 25000000;
                this.equipamiento = "Aire acondicionado básico";
            }
            default -> { // Usado
                this.velocidadMaxima = 100;
                this.precio = 15000000;
                this.equipamiento = "Radio básico + Mantenimiento al día";
            }
        }

        // Ajuste si es vehículo Aéreo (más costoso y veloz)
        if (tipo.equals("Avión") || tipo.equals("Avioneta") || tipo.equals("Helicóptero")) {
            this.precio += 100000000;
            this.velocidadMaxima += 200;
        }
    }
}

/**
 * PATRÓN CREACIONAL: Factory Method
 */
class VehiculoFactory {
    public static Vehiculo crearVehiculo(int tipoOpt, int catOpt, int modOpt) {
        String categoria = (catOpt == 1) ? "Económico" : (catOpt == 2) ? "Lujo" : "Usado";
        String tipo = "";

        // Determinamos el modelo según la familia
        if (tipoOpt == 1) { // Tierra
            tipo = (modOpt == 1) ? "Auto" : (modOpt == 2) ? "Bicicleta" : "Moto";
        } else if (tipoOpt == 2) { // Acuático
            tipo = (modOpt == 1) ? "Lancha" : (modOpt == 2) ? "Velero" : "Jet Ski";
        } else { // Aéreo
            tipo = (modOpt == 1) ? "Avión" : (modOpt == 2) ? "Avioneta" : "Helicóptero";
        }

        return new VehiculoConcreto(tipo, categoria);
    }
}

/**
 * CLASE PRINCIPAL (Debe llamarse Reto3.java)
 */
public class Reto3 {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        List<Vehiculo> carrito = new ArrayList<>();
        String continuar;

        System.out.println("¡Bienvenido al Reino de los Vehículos!");

        do {
            System.out.println("\nSeleccione el tipo de vehículo:\n1. Tierra\n2. Acuático\n3. Aéreo");
            int tipoNum = sc.nextInt();

            System.out.println("\nSeleccione la categoría del vehículo:\n1. Económico\n2. Lujo\n3. Usado");
            int catNum = sc.nextInt();

            System.out.println("\nSeleccione el modelo de vehículo (1, 2 o 3):");
            int modNum = sc.nextInt();

            Vehiculo v = VehiculoFactory.crearVehiculo(tipoNum, catNum, modNum);
            carrito.add(v);

            System.out.print("\n¿Desea agregar otro vehículo? (si/no): ");
            continuar = sc.next();

        } while (continuar.equalsIgnoreCase("si"));

        // --- SALIDA CON STREAMS ---
        System.out.println("\n-- RESUMEN DE COMPRA");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.println("Vehículo " + (i + 1) + ":");
            System.out.println(carrito.get(i));
            System.out.println();
        }

        double total = carrito.stream()
                .mapToDouble(Vehiculo::getPrecio)
                .sum();

        System.out.println("Subtotal: $" + String.format("%.0f", total));
        System.out.println("Descuento aplicado: $0");
        System.out.println("Total a pagar: $" + String.format("%.0f", total));
        System.out.println("\n¡Gracias por su compra en el Reino de los Vehículos!");
    }
}