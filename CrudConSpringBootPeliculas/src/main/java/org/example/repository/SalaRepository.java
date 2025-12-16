package org.example.repository;

import org.example.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
