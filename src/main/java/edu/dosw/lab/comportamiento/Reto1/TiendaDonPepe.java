package edu.dosw.lab.comportamiento.Reto1;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un producto inmutable en la tienda.
 * Cumple con el Encapsulamiento y la Inmutabilidad.
 */
class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

/**
 * Clase abstracta que define la estructura de un Cliente.
 * Aplica POLIMORFISMO y el principio de Abierto/Cerrado (SOLID).
 */
abstract class Cliente {
    private final String nombre;
    
    public Cliente(String nombre) { this.nombre = nombre; }
    
    public String getNombre() { return nombre; }
    
    // Método abstracto que cada tipo de cliente implementará
    public abstract double aplicarDescuento(double total);
}

class ClienteNuevo extends Cliente {
    public ClienteNuevo(String nombre) { super(nombre); }
    
    @Override
    public double aplicarDescuento(double total) { 
        return total * 0.95; // 5% de descuento
    }
}

class ClienteFrecuente extends Cliente {
    public ClienteFrecuente(String nombre) { super(nombre); }
    
    @Override
    public double aplicarDescuento(double total) { 
        return total * 0.90; // 10% de descuento
    }
}

/**
 * Representa la unión de un producto y su cantidad.
 * SOLID: Responsabilidad Única (S).
 */
class ItemCarrito {
    private final Producto producto;
    private final int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
}

/**
 * Gestiona la lógica de la compra usando STREAMS.
 */
class Carrito {
    private final List<ItemCarrito> items = new ArrayList<>();

    public void agregarItem(ItemCarrito item) {
        items.add(item);
        System.out.println(item.getProducto().getNombre() + " " + item.getCantidad() + " unidades agregado al carrito.");
    }

    public double calcularMontoSubtotal() {
        // Uso de STREAMS: mapToDouble para obtener precios y sum() para totalizar
        return items.stream()
                    .mapToDouble(ItemCarrito::calcularSubtotal)
                    .sum();
    }

    public void generarRecibo(Cliente cliente) {
        double subtotal = calcularMontoSubtotal();
        double totalFinal = cliente.aplicarDescuento(subtotal);

        System.out.println("\nRECIBO DE COMPRA");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Productos:");
        
        // Uso de STREAMS: forEach para recorrer e imprimir
        items.stream().forEach(item -> {
            System.out.println("- " + item.getProducto().getNombre() + " - $" + item.calcularSubtotal());
        });

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento aplicado: $" + (subtotal - totalFinal));
        System.out.println("Total a pagar: $" + totalFinal);
        System.out.println("------------------------");
        System.out.println("¡Gracias por su compra!");
    }
}

public class TiendaDonPepe {
    public static void ejecutar() {
        // 1. Inicialización de productos
        Producto camiseta = new Producto("Camiseta", 20000);
        Producto pantalon = new Producto("Pantalón", 50000);
        Producto galletas = new Producto("Galletas", 500);
        Producto jugo = new Producto("Jugo Natural", 3000);

        // 2. Definición del cliente (Polimorfismo en acción)
        Cliente miCliente = new ClienteFrecuente("Frecuente");

        // 3. Proceso de compra
        Carrito carrito = new Carrito();
        System.out.println("¡Bienvenido a la tienda Don Pepe!");
        
        carrito.agregarItem(new ItemCarrito(camiseta, 2));
        carrito.agregarItem(new ItemCarrito(galletas, 3));
        carrito.agregarItem(new ItemCarrito(jugo, 5));

        // 4. Salida
        carrito.generarRecibo(miCliente);
    }
}