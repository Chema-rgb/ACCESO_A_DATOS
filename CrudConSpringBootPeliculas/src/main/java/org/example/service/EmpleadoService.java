package org.example.service;

import org.example.entity.Empleado;
import org.example.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    // Insertar un nuevo empleado
    public Empleado insertar(Empleado empleado) {
        empleado.setActivo(true); // siempre activo al crear
        empleado.setFechaBaja(null); // sin fecha de baja al crear
        return repository.save(empleado);
    }

    // Obtener todos los empleados
    public List<Empleado> obtenerTodos() {
        return repository.findAll();
    }

    // Obtener empleado por ID
    public Optional<Empleado> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    // Actualizar un empleado
    public Empleado actualizar(Empleado empleado) {
        return repository.save(empleado);
    }

    // Eliminar empleado
    public void eliminar(Integer id) {
        repository.findById(id).ifPresent(empleado -> {
            empleado.setActivo(false);
            empleado.setFechaBaja(new Date()); // registrar fecha de baja
            repository.save(empleado);
        });
    }
}
