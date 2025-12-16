package org.example.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Proyecciones")
public class Proyecciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProyeccion;

    @ManyToOne
    @JoinColumn(name = "idPelicula", nullable = false)
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "idSala", nullable = false)
    private Sala sala;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFin;

    private BigDecimal precioEntrada;
    private int asientosDisponibles;


    // GETTERS Y SETTERS

    public Integer getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(Integer idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(Date fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Date getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(Date fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public BigDecimal getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(BigDecimal precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
}
