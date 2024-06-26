package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Autor;
import com.alura.challengejavalivros.model.AutorDb;
import com.alura.challengejavalivros.model.LivroDb;
import com.alura.challengejavalivros.model.Results;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositoy extends JpaRepository<AutorDb, Long> {
}
