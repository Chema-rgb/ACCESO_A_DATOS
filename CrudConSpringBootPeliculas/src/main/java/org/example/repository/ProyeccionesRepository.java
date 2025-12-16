package org.example.repository;

import org.example.entity.Proyecciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionesRepository extends JpaRepository<Proyecciones, Integer> {
}
