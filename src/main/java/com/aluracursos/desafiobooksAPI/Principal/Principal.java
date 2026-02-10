package com.aluracursos.desafiobooksAPI.Principal;

import com.aluracursos.desafiobooksAPI.model.Datos;
import com.aluracursos.desafiobooksAPI.model.DatosLibros;
import com.aluracursos.desafiobooksAPI.service.BookService;
import com.aluracursos.desafiobooksAPI.service.ConsumoAPIlibros;
import com.aluracursos.desafiobooksAPI.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class Principal {

    private final BookService bookService;
    private final Scanner scanner = new Scanner(System.in);

    public Principal(BookService bookService) {
        this.bookService = bookService;
    }

    public void mostrarMenu() {

        int opcion = -1;

        while (opcion != 0) {
            imprimirMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    bookService.buscarYGuardarLibroPorTitulo(titulo);
                }

                case 2 -> bookService.listarLibros();

                case 3 -> {
                    System.out.print("Ingrese el idioma (ej. en, es): ");
                    String idioma = scanner.nextLine();
                    bookService.listarLibrosPorIdioma(idioma);
                }

                case 4 -> bookService.listarAutores();

                case 5 -> {
                    System.out.print("Ingrese el año a consultar: ");
                    try {
                        int anio = Integer.parseInt(scanner.nextLine());
                        bookService.listarAutoresVivosEnAnio(anio);
                    } catch (NumberFormatException e) {
                        System.out.println("Año inválido.");
                    }
                }

                case 6 -> bookService.mostrarEstadisticasPorIdioma();

                case 0 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void imprimirMenu() {
        System.out.println("""
                
                ======================================
                          CATÁLOGO DE LIBROS
                ======================================
                1 - Buscar libro por título
                2 - Listar todos los libros
                3 - Listar libros por idioma
                4 - Listar autores
                5 - Listar autores vivos en un año
                6 - Mostrar estadísticas por idioma
                0 - Salir
                --------------------------------------
                Seleccione una opción:
                """);
    }
}
