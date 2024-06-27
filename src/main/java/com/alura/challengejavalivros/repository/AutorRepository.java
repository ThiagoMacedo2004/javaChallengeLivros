package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    boolean existsByNome(String nome);
}
