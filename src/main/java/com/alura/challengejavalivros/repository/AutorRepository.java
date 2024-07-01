package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Autor findByNome(String nome);
}
