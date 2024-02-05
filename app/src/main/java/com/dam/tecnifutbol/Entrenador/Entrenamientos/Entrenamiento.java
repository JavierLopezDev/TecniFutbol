package com.dam.tecnifutbol.Entrenador.Entrenamientos;

public class Entrenamiento {
    private String nombre;
    private String descripcion;
    private String edadesCategoria;
    private String dificultad;
    private String duracion;
    private String materiales;
    private String tipo;
    private int imagen;
    private String video;

    public Entrenamiento() {
    }

    public Entrenamiento(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Entrenamiento(String nombre, String descripcion, String edadesCategoria, String dificultad, String duracion, String materiales, String tipo, String video) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edadesCategoria = edadesCategoria;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.materiales = materiales;
        this.tipo = tipo;
        this.video = video;
    }

    public Entrenamiento(String nombre, String descripcion, String edadesCategoria, String dificultad, String duracion, String materiales, String tipo, int imagen, String video) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.edadesCategoria = edadesCategoria;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.materiales = materiales;
        this.tipo = tipo;
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

    public String getEdadesCategoria() {
        return edadesCategoria;
    }

    public void setEdadesCategoria(String edadesCategoria) {
        this.edadesCategoria = edadesCategoria;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
