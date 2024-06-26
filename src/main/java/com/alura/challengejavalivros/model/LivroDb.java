package com.alura.challengejavalivros.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class LivroDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne
    private AutorDb autor;

    public LivroDb(){}

    public LivroDb(Results results) {
        this.titulo = results.titulo();
        this.idioma = results.idioma().getFirst();
        this.downloads = results.downloads();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public AutorDb getAutor() {
        return autor;
    }

    public void setAutor(AutorDb autor) {
        this.autor = autor;
    }
}
