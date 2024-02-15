package com.dam.tecnifutbol.Entrenador.Partidos;

import java.io.Serializable;

public class Equipo implements Serializable {
    private String nombre;
    private String categoria;
    private int jugadores;

    public Equipo(String nombre, String categoria, int jugadores) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.jugadores = jugadores;
    }

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getJugadores() {
        return jugadores;
    }

    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }
}
