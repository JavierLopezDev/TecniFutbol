package com.dam.tecnifutbol.Entrenador.Partidos;

public class Jugador {
    private String nombre;
    private String posicion;

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }
}
