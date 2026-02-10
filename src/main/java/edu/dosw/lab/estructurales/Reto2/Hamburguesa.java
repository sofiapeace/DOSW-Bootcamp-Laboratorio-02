package edu.dosw.lab.estructurales.Reto2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Compuesta
 * Mantiene una lista de ingredientes y calcula el total usando Streams
 */
public class Hamburguesa implements Ingrediente {
    private List<Ingrediente> ingredientes = new ArrayList<>();

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String getNombre() {
        // Une los nombres de los ingredientes con comas usando Streams
        return ingredientes.stream()
                .map(Ingrediente::getNombre)
                .collect(Collectors.joining(", "));
    }

    @Override
    public double getPrecio() {
        // Suma los precios de todos los ingredientes usando Streams
        return ingredientes.stream()
                .mapToDouble(Ingrediente::getPrecio)
                .sum();
    }
}

