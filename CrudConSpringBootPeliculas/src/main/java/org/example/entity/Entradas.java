package org.example.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Entradas")
public class Entradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEntrada;

    @ManyToOne
    @JoinColumn(name = "idProyeccion", nullable = false)
    private Proyecciones proyeccion;

    @Column(nullable = false)
    private Integer numeroAsiento;

    @Column(nullable = false)
    private BigDecimal precio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;

    @Column(length = 20)
    private String estado;


    // GETTERS Y SETTERS

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Proyecciones getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyecciones proyeccion) {
        this.proyeccion = proyeccion;
    }

    public Integer getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(Integer numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
