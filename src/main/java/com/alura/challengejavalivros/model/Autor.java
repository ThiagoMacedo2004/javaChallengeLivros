package com.alura.challengejavalivros.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Autor(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") Integer dataNascimento,
        @JsonAlias("death_year") Integer dataMorte

) {
}
