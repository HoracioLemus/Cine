/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Asiento {
    private int fila;
    private char columna;
    private Espectador espectador;

    public Asiento(int fila, char columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    public boolean estaOcupado() {
        return espectador != null;
    }

    @Override
    public String toString() {
        if (estaOcupado()) {
            return "[" + espectador.getNombre() + "]";
        } else {
            return "[ ]";
        }
    }
}
