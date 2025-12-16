package org.example.controller;

import org.example.entity.Entradas;
import org.example.service.EntradasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradasController {

    private final EntradasService service;

    public EntradasController(EntradasService service) {
        this.service = service;
    }

    //IMPLEMTENTACIONES
    @PostMapping("/comprar")
    public ResponseEntity<Entradas> comprarEntrada(
            @RequestParam Integer idProyeccion,
            @RequestParam Integer numeroAsiento) {

        Entradas entrada = service.comprarEntrada(idProyeccion, numeroAsiento);
        return ResponseEntity.ok(entrada);
    }


    @GetMapping("/{id}/estado")
    public ResponseEntity<String> comprobarEstado(@PathVariable Integer id) {
        String estado = service.comprobarEstadoEntrada(id);
        return ResponseEntity.ok(estado);
    }

   //BASICOS

    @GetMapping
    public ResponseEntity<List<Entradas>> obtenerTodas() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entradas> obtenerPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Entradas> actualizar(@RequestBody Entradas entrada) {
        return ResponseEntity.ok(service.actualizar(entrada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
