package edu.dosw.lab.estructurales.Reto2;

import java.util.Scanner;

public class Reto2 {
    public static void ejecutar() {
        Scanner sc = new Scanner(System.in);
        Hamburguesa miHamburguesa = new Hamburguesa();
        
        System.out.println("EL CHEF DE 5 ESTRELLAS");
        System.out.println("Seleccione ingredientes (0 para terminar):");
        System.out.println("1. Pan ($3000)\n2. Carne ($10000)\n3. Queso ($5000)\n4. Tocino ($4000)");

        int opcion;
        do {
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> miHamburguesa.agregarIngrediente(new IngredienteIndividual("Pan", 3000));
                case 2 -> miHamburguesa.agregarIngrediente(new IngredienteIndividual("Carne", 10000));
                case 3 -> miHamburguesa.agregarIngrediente(new IngredienteIndividual("Queso", 5000));
                case 4 -> miHamburguesa.agregarIngrediente(new IngredienteIndividual("Tocino", 4000));
            }
        } while (opcion != 0);

        System.out.println("\nHAMBURGUESA PERSONALIZADA");
        System.out.println("Ingredientes seleccionados: " + miHamburguesa.getNombre());
        System.out.println("Precio total: $" + String.format("%.0f", miHamburguesa.getPrecio()));
        System.out.println("¡Disfrute su hamburguesa!");
    }
}