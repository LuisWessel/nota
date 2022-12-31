package com.example.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nota.models.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {
    Nota findById(long id);
}