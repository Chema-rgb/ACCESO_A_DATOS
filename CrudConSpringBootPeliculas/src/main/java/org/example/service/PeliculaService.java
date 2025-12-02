package org.example.service;

import org.example.entity.Pelicula;
import org.example.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public Pelicula insertar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    public List<Pelicula> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Pelicula> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Pelicula actualizar(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
