package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositoy extends JpaRepository<Livro, Long> {
    boolean existsByTitulo(String titulo);

    Livro findByTitulo(String titulo);
}
