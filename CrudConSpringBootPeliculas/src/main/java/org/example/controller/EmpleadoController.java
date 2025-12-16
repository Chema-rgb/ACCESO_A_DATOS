package org.example.controller;

import org.example.entity.Empleado;
import org.example.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public Empleado crear(@RequestBody Empleado empleado) {
        return service.insertar(empleado);
    }

    @GetMapping
    public List<Empleado> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> actualizar(@PathVariable Integer id, @RequestBody Empleado empleado) {
        return service.obtenerPorId(id)
                .map(e -> {
                    empleado.setIdEmpleado(id);
                    return ResponseEntity.ok(service.actualizar(empleado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id); // Soft delete: marca activo = false y fechaBaja
        return ResponseEntity.noContent().build();
    }
}
