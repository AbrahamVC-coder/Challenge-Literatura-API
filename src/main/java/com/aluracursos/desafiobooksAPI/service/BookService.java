package com.aluracursos.desafiobooksAPI.service;

import com.aluracursos.desafiobooksAPI.dto.AuthorDTO;
import com.aluracursos.desafiobooksAPI.dto.BookDTO;
import com.aluracursos.desafiobooksAPI.dto.GutendexResponse;
import com.aluracursos.desafiobooksAPI.model.Author;
import com.aluracursos.desafiobooksAPI.model.AuthorRepository;
import com.aluracursos.desafiobooksAPI.model.Book;
import com.aluracursos.desafiobooksAPI.model.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ConsumoAPIlibros consumoAPI;
    private final ObjectMapper mapper = new ObjectMapper();

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.consumoAPI = new ConsumoAPIlibros();
    }

    public Book buscarYGuardarLibroPorTitulo(String titulo) {

        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        String json = consumoAPI.traerDatos(url);

        try {
            GutendexResponse response =
                    mapper.readValue(json, GutendexResponse.class);

            if (response.getResults().isEmpty()) {
                System.out.println("❌ No se encontraron libros.");
                return null;
            }

            BookDTO bookDTO = response.getResults().get(0);

            // Autor (solo el primero)
            AuthorDTO authorDTO = bookDTO.authors().get(0);

            Optional<Author> authorExistente =
                    authorRepository.findByNombreIgnoreCase(authorDTO.nombre());

            Author author = authorExistente.orElseGet(() ->
                    authorRepository.save(
                            new Author(
                                    authorDTO.nombre(),
                                    authorDTO.birthYear(),
                                    authorDTO.deathYear()
                            )
                    )
            );

            // Libro
            Book book = new Book(
                    bookDTO.title(),
                    bookDTO.languages().get(0),
                    bookDTO.downloadCount(),
                    author
            );

            return bookRepository.save(book);

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el libro", e);
        }
    }

    public void listarLibros(){
        var libros = bookRepository.findAll();

        if(libros.isEmpty()){
            System.out.println("No hay libros registrados.");
            return;
        }

        System.out.println("\n LIBROS REGISTRADOS \n");

        libros.forEach(System.out::println);
    }

    public void listarLibrosPorIdioma(String idioma){
        var libros = bookRepository.findByLanguage(idioma);

        if(libros.isEmpty()){
            System.out.println("No hay libros registrados " + idioma);
            return;
        }

        System.out.println("\n LIBROS EN IDIOMA: " + idioma.toUpperCase() + "\n");

        libros.forEach(System.out::println);
    }

    public void listarAutores() {

        var autores = authorRepository.findAll();

        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
            return;
        }

        System.out.println("\n️ AUTORES REGISTRADOS\n");

        autores.forEach(autor -> {
            System.out.println(
                    autor.getNombre() +
                            " | Nacimiento: " + autor.getBirthYear() +
                            " | Fallecimiento: " +
                            (autor.getDeathYear() != null ? autor.getDeathYear() : "Vivo")
            );
        });
    }

    public void listarAutoresVivosEnAnio(Integer anio) {

        var autoresFallecidos =
                authorRepository
                        .findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(anio, anio);

        var autoresVivos =
                authorRepository
                        .findByBirthYearLessThanEqualAndDeathYearIsNull(anio);

        var autores = new java.util.ArrayList<Author>();
        autores.addAll(autoresFallecidos);
        autores.addAll(autoresVivos);

        if (autores.isEmpty()) {
            System.out.println("No se encontraron autores vivos en el año " + anio);
            return;
        }

        System.out.println("\n AUTORES VIVOS EN EL AÑO " + anio + "\n");

        autores.forEach(autor -> {
            System.out.println(
                    autor.getNombre() +
                            " | Nacimiento: " + autor.getBirthYear() +
                            " | Fallecimiento: " +
                            (autor.getDeathYear() != null ? autor.getDeathYear() : "Vivo")
            );
        });
    }

    public void mostrarEstadisticasPorIdioma(){
        var libros = bookRepository.findAll();

        if(libros.isEmpty()){
            System.out.println("No hay libros registrados");
            return;
        }

        System.out.println("\n CANTIDAD DE LIBROS POR IDIOMA\n");

        var estadisticas = libros.stream()
                .collect(
                        java.util.stream.Collectors.groupingBy(
                                Book::getLanguage,
                                java.util.stream.Collectors.counting()
                        )
                );

        estadisticas.forEach((idioma, cantidad) ->
        System.out.println("idioma: " + idioma + "| Libros: " + cantidad)
        );
    }




}

