package com.alura.challengejavalivros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Results(
        @JsonAlias("title") String titulo,
        @JsonAlias("authors") List<Autor> autores,
        @JsonAlias("languages") List<String> idioma,
        @JsonAlias("download_count") Integer downloads
) {
}
