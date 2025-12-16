package org.example.repository;

import org.example.entity.Entradas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradasRepository extends JpaRepository<Entradas, Integer> {
}
