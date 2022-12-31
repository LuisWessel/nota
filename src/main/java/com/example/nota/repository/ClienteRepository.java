package com.example.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nota.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findById(long Id);
}
