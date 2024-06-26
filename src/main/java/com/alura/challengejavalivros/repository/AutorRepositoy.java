package com.alura.challengejavalivros.repository;

import com.alura.challengejavalivros.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositoy extends JpaRepository<Livro, Long> {
}
