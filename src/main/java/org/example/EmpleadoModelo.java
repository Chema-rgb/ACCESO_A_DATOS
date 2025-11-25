package org.example;

import java.math.BigDecimal;
import java.sql.Date;

public class EmpleadoModelo {
    private int idEmpleado;
    private String nombre;
    private String puesto;
    private String tipoJornada;
    private String email;
    private String telefono;
    private Date fechaContratacion;
    private BigDecimal salarioHora;
    private boolean activo;

    // Getters y setters
    public int getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getTipoJornada() { return tipoJornada; }
    public void setTipoJornada(String tipoJornada) { this.tipoJornada = tipoJornada; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Date getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public BigDecimal getSalarioHora() { return salarioHora; }
    public void setSalarioHora(BigDecimal salarioHora) { this.salarioHora = salarioHora; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
}
