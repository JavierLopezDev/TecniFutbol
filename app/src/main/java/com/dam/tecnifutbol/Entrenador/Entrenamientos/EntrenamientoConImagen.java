package com.dam.tecnifutbol.Entrenador.Entrenamientos;

public class EntrenamientoConImagen {
    private String nombre;
    private int imagen;

    public EntrenamientoConImagen() {
    }

    public EntrenamientoConImagen(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
