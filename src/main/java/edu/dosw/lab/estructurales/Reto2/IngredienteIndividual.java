package edu.dosw.lab.estructurales.Reto2;

/**
 * Clase Hoja (Leaf) del patrón Composite.
 * Representa un ingrediente que no contiene otros elementos.
 */
public class IngredienteIndividual implements Ingrediente {
    private String nombre;
    private double precio;

    public IngredienteIndividual(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String getNombre() { return nombre; }

    @Override
    public double getPrecio() { return precio; }
}
