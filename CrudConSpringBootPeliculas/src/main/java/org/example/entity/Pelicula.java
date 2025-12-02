package org.example.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPelicula;

    private String titulo;
    private int duracionMinutos;
    private String genero;
    private String clasificacion;
    private String director;
    private String sinopsis;

    @Temporal(TemporalType.DATE)
    private Date fechaEstreno;

    private int popularidad;
    private boolean activa;

    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    // Getters y setters
    public Integer getIdPelicula() { return idPelicula; }
    public void setIdPelicula(Integer idPelicula) { this.idPelicula = idPelicula; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String sinopsis) { this.sinopsis = sinopsis; }
    public Date getFechaEstreno() { return fechaEstreno; }
    public void setFechaEstreno(Date fechaEstreno) { this.fechaEstreno = fechaEstreno; }
    public int getPopularidad() { return popularidad; }
    public void setPopularidad(int popularidad) { this.popularidad = popularidad; }
    public boolean isActiva() { return activa; }
    public void setActiva(boolean activa) { this.activa = activa; }
    public Date getFechaBaja() { return fechaBaja; }
    public void setFechaBaja(Date fechaBaja) { this.fechaBaja = fechaBaja; }
}