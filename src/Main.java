/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class Main {
public static void main(String[] args) {
// Creación de la película
    try (Scanner sc = new Scanner(System.in)) {
        // Creación de la película
        System.out.println("Ingrese los datos de la película:");
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Duración (en minutos): ");
        int duracion = sc.nextInt();
        System.out.print("Edad mínima: ");
        int edadMinima = sc.nextInt();
        sc.nextLine();
        System.out.print("Director: ");
        String director = sc.nextLine();
        System.out.print("Precio de la entrada: ");
        double precioEntrada = sc.nextDouble();
        sc.nextLine();
        Pelicula pelicula = new Pelicula(titulo, duracion, edadMinima, director, precioEntrada);
        
        // Creación del cine
        Cine cine = new Cine(pelicula);
        
        // Creación de los espectadores
        System.out.print("Ingrese la cantidad de espectadores: ");
        int cantidadEspectadores = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < cantidadEspectadores; i++) {
            System.out.println("Ingrese los datos del espectador " + (i+1) + ":");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            System.out.print("Dinero: ");
            double dinero = sc.nextDouble();
            sc.nextLine();
            Espectador espectador = new Espectador(nombre, edad, dinero);
            
            // Asignación del asiento al espectador
            Asiento asiento = cine.asignarAsiento(espectador);
            if (asiento != null) {
                System.out.println(espectador.getNombre() + " se ha sentado en el asiento " + asiento.getFila() + asiento.getColumna());
            } else {
                System.out.println(espectador.getNombre() + " no ha podido sentarse en la sala.");
            }
        }
        
        // Información final del cine
        System.out.println();
        cine.mostrarSala();
        System.out.println("Recaudación total: " + cine.calcularRecaudacion() + " dólares");
    }
}
}