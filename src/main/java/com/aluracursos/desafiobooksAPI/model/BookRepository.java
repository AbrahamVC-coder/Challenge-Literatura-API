package com.aluracursos.desafiobooksAPI.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Buscar libros por idioma
    List<Book> findByLanguage(String language);

    // Buscar libro por título (útil para evitar duplicados)
    Optional<Book> findByTitleContainingIgnoreCase(String title);
}
