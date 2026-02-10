package com.aluracursos.desafiobooksAPI.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        String title,
        List<AuthorDTO> authors,
        List<String> languages,

        @JsonAlias("download_count")
        Integer downloadCount
) {

    @Override
    public String title() {
        return title;
    }

    @Override
    public List<AuthorDTO> authors() {
        return authors;
    }

    @Override
    public List<String> languages() {
        return languages;
    }

    @Override
    public Integer downloadCount() {
        return downloadCount;
    }
}
