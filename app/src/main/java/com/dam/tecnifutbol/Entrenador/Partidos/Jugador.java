package com.dam.tecnifutbol.Entrenador.Partidos;

public class Jugador {
    private String nombre;
    private String posicion;
    private int goles;
    private int tarjetaRoja;
    private int tarjetaAmarilla;
    private int faltasRealizadas;

    public Jugador(String nombre, String posicion, int goles, int tarjetaRoja, int tarjetaAmarilla) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.goles = goles;
        this.tarjetaRoja = tarjetaRoja;
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

    public Jugador(String nombre, String posicion, int goles, int tarjetaRoja, int tarjetaAmarilla, int faltasRealizadas) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.goles = goles;
        this.tarjetaRoja = tarjetaRoja;
        this.tarjetaAmarilla = tarjetaAmarilla;
        this.faltasRealizadas = faltasRealizadas;
    }

    public int getFaltasRealizadas() {
        return faltasRealizadas;
    }

    public void setFaltasRealizadas(int faltasRealizadas) {
        this.faltasRealizadas = faltasRealizadas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getTarjetaRoja() {
        return tarjetaRoja;
    }

    public void setTarjetaRoja(int tarjetaRoja) {
        this.tarjetaRoja = tarjetaRoja;
    }

    public int getTarjetaAmarilla() {
        return tarjetaAmarilla;
    }

    public void setTarjetaAmarilla(int tarjetaAmarilla) {
        this.tarjetaAmarilla = tarjetaAmarilla;
    }

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
