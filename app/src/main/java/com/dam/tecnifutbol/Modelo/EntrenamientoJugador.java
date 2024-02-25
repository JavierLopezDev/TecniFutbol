package com.dam.tecnifutbol.Modelo;

public class EntrenamientoJugador {

    private String nombre;
    private String descripcion;
    private String lugar;
    private String repeticiones;
    private String nota;
    private int imagen;
    private String video;

    public EntrenamientoJugador() {
    }

    public EntrenamientoJugador(String nombre, String descripcion, String lugar, String repeticiones, String nota, int imagen, String video) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.repeticiones = repeticiones;
        this.nota = nota;
        this.imagen = imagen;
        this.video = video;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(String repeticiones) {
        this.repeticiones = repeticiones;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
