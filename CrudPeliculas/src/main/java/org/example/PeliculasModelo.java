package org.example;

import java.util.Date;

public class PeliculasModelo {

    private int id_pelicula;

    private String titulo;

    private int duracion_minutos;

    private String genero;

    private String clasificacion;

    private String director;

    private String sinopsis;

    private Date fecha_estreno;

    private int popularidad;

    private boolean activa;

    private Date fechaBaja;

    //GETTERS AND SETTERS


    public int getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion_minutos() {
        return duracion_minutos;
    }

    public void setDuracion_minutos(int duracion_minutos) {
        this.duracion_minutos = duracion_minutos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public java.sql.Date getFechaEstreno() {
        return (java.sql.Date) fecha_estreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fecha_estreno = fechaEstreno;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public java.sql.Date getFechaBaja() {
        return (java.sql.Date) fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
