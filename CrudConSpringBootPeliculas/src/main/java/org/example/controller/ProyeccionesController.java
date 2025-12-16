package org.example.controller;

import org.example.entity.Proyecciones;
import org.example.service.ProyeccionesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionesController {

    private final ProyeccionesService service;

    public ProyeccionesController(ProyeccionesService service) {
        this.service = service;
    }

    @PostMapping
    public Proyecciones crear(@RequestBody Proyecciones proyeccion) {
        return service.insertar(proyeccion);
    }

    @GetMapping
    public List<Proyecciones> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyecciones> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyecciones> actualizar(@PathVariable Integer id, @RequestBody Proyecciones proyeccion) {
        return service.obtenerPorId(id)
                .map(p -> {
                    proyeccion.setIdProyeccion(id);
                    return ResponseEntity.ok(service.actualizar(proyeccion));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
