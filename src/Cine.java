/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Usuario
 */
public class Cine {
    private Pelicula pelicula;
    private Asiento[][] sala;
    private ArrayList<Espectador> espectadores;

    public Cine(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.sala = new Asiento[8][10];
        this.espectadores = new ArrayList<>();
        generarSala();
    }

    private void generarSala() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                sala[i][j] = new Asiento(i + 1, (char) (j + 1));
            }
        }
    }

    public void mostrarSala() {
        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                if (sala[i][j].getEspectador() != null) {
                    System.out.print("[" + sala[i][j].getEspectador().getNombre().charAt(0) + "]");
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
    }

     Asiento asignarAsiento(Espectador espectador) {
        if (espectador.getDinero() < pelicula.getPrecioEntrada()) {
            return null;
        }

        if (espectador.getEdad() < pelicula.getEdadMinima()) {
            return null;
        }

        ArrayList<Asiento> asientosDisponibles = new ArrayList<>();

        for (int i = 0; i < sala.length; i++) {
            for (int j = 0; j < sala[i].length; j++) {
                if (sala[i][j].getEspectador() == null) {
                    asientosDisponibles.add(sala[i][j]);
                }
            }
        }

        if (asientosDisponibles.isEmpty()) {
            return null;
        }

        Random rnd = new Random();
        int index = rnd.nextInt(asientosDisponibles.size());
        Asiento asiento = asientosDisponibles.get(index);
        asiento.setEspectador(espectador);
        espectadores.add(espectador);
        return asiento;
    }

    public double calcularRecaudacion() {
        return espectadores.size() * pelicula.getPrecioEntrada();
    }

}
