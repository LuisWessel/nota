package com.example.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nota.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Produto findById(long Id);
}
