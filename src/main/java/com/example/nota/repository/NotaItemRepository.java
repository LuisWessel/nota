package com.example.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nota.models.NotaItem;

public interface NotaItemRepository  extends JpaRepository<NotaItem, Long> {
    NotaItem findById(long id);
}
