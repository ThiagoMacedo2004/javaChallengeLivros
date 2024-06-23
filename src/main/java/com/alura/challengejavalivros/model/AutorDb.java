package com.alura.challengejavalivros.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "autores")
public class AutorDb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private Integer dataNascimento;

    private Integer dataMorte;

    public AutorDb(Autor autor){
        this.nome = autor.nome();
        this.dataNascimento = autor.dataNascimento();
        this.dataMorte = autor.dataMorte();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Integer dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(Integer dataMorte) {
        this.dataMorte = dataMorte;
    }



}