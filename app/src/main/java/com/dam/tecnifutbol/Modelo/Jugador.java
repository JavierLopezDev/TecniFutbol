package com.dam.tecnifutbol.Modelo;

public class Jugador {

    int id;
    String equipo;
    String nombre;
    String dorsal;
    String posicion;
    String peso;
    String altura;
    String fechaNacimiento;
    String piernaHabil;
    String notas;
    boolean disponible;

    public Jugador() {
    }

    public Jugador(int id, String equipo, String nombre, String dorsal, String posicion, String peso, String altura, String fechaNacimiento, String piernaHabil, String notas, boolean disponible) {
        this.id = id;
        this.equipo = equipo;
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.fechaNacimiento = fechaNacimiento;
        this.piernaHabil = piernaHabil;
        this.notas = notas;
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPiernaHabil() {
        return piernaHabil;
    }

    public void setPiernaHabil(String piernaHabil) {
        this.piernaHabil = piernaHabil;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
