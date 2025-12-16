package org.example.service;

import org.example.entity.Entradas;
import org.example.entity.Proyecciones;
import org.example.repository.EntradasRepository;
import org.example.repository.ProyeccionesRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EntradasService {

    private final EntradasRepository entradasRepository;
    private final ProyeccionesRepository proyeccionesRepository;

    public EntradasService(EntradasRepository entradasRepository,
                           ProyeccionesRepository proyeccionesRepository) {
        this.entradasRepository = entradasRepository;
        this.proyeccionesRepository = proyeccionesRepository;
    }


    public Entradas comprarEntrada(Integer idProyeccion, Integer numeroAsiento) {

        Proyecciones proyeccion = proyeccionesRepository.findById(idProyeccion)
                .orElseThrow(() -> new RuntimeException("Proyección no encontrada"));


        if (proyeccion.getAsientosDisponibles() <= 0) {
            throw new RuntimeException("No hay asientos disponibles para esta proyección");
        }

        Entradas entrada = new Entradas();
        entrada.setProyeccion(proyeccion);
        entrada.setNumeroAsiento(numeroAsiento);
        entrada.setPrecio(proyeccion.getPrecioEntrada());
        entrada.setFechaCompra(new Date());
        entrada.setEstado("VENDIDA");


        proyeccion.setAsientosDisponibles(
                proyeccion.getAsientosDisponibles() - 1
        );

        proyeccionesRepository.save(proyeccion);
        return entradasRepository.save(entrada);
    }


    public String comprobarEstadoEntrada(Integer idEntrada) {
        Entradas entrada = entradasRepository.findById(idEntrada)
                .orElseThrow(() -> new RuntimeException("Entrada no encontrada"));

        return entrada.getEstado();
    }

    // BÁSICO

    public List<Entradas> obtenerTodas() {
        return entradasRepository.findAll();
    }

    public Optional<Entradas> obtenerPorId(Integer id) {
        return entradasRepository.findById(id);
    }

    public Entradas actualizar(Entradas entrada) {
        return entradasRepository.save(entrada);
    }

    public void eliminar(Integer id) {
        entradasRepository.deleteById(id);
    }
}
