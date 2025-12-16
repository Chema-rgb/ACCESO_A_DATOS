package org.example.controller;

import org.example.entity.Sala;
import org.example.service.SalaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    public Sala crear(@RequestBody Sala sala) {
        return service.insertar(sala);
    }

    @GetMapping
    public List<Sala> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(@PathVariable Integer id, @RequestBody Sala sala) {
        return service.obtenerPorId(id)
                .map(s -> {
                    sala.setIdSala(id);
                    return ResponseEntity.ok(service.actualizar(sala));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
