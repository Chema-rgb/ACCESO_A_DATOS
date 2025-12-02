package org.example.controller;

import org.example.entity.Pelicula;
import org.example.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @PostMapping
    public Pelicula crear(@RequestBody Pelicula pelicula) {
        return service.insertar(pelicula);
    }

    @GetMapping
    public List<Pelicula> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Integer id, @RequestBody Pelicula pelicula) {
        return service.obtenerPorId(id)
                .map(p -> {
                    pelicula.setIdPelicula(id);
                    return ResponseEntity.ok(service.actualizar(pelicula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
