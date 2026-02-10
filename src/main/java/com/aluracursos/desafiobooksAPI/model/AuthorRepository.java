package com.aluracursos.desafiobooksAPI.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // Buscar autor por nombre (para evitar duplicados)
    Optional<Author> findByNombreIgnoreCase(String nombre);

    // Autores vivos en un año determinado
    List<Author> findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(
            Integer year1,
            Integer year2
    );

    // Para autores que siguen vivos (deathYear = null)
    List<Author> findByBirthYearLessThanEqualAndDeathYearIsNull(Integer year);
}
