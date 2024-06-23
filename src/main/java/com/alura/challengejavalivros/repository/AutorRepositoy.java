package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Autor;
import com.alura.challengejavalivros.model.AutorDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositoy extends JpaRepository<AutorDb, Long> {
}
