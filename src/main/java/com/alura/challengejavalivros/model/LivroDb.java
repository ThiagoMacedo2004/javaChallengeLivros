package com.alura.challengejavalivros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class LivroDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String idioma;
    private Integer downloads;
}
