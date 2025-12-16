package org.example.service;

import org.example.entity.Proyecciones;
import org.example.repository.ProyeccionesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyeccionesService {

    private final ProyeccionesRepository repository;

    public ProyeccionesService(ProyeccionesRepository repository) {
        this.repository = repository;
    }

    public Proyecciones insertar(Proyecciones proyeccion) {
        return repository.save(proyeccion);
    }

    public List<Proyecciones> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Proyecciones> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Proyecciones actualizar(Proyecciones proyeccion) {
        return repository.save(proyeccion);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}


