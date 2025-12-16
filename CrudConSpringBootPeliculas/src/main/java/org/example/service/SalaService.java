package org.example.service;

import org.example.entity.Sala;
import org.example.repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public Sala insertar(Sala sala) {
        return repository.save(sala);
    }

    public List<Sala> obtenerTodas() {
        return repository.findAll();
    }

    public Optional<Sala> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    public Sala actualizar(Sala sala) {
        return repository.save(sala);
    }

    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
