package com.aluracursos.desafiobooksAPI.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(nullable = false)
    private String language;

    private Integer downloads;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, String language, Integer downloads, Author author) {
        this.title = title;
        this.language = language;
        this.downloads = downloads;
        this.author = author;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Author getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Libro: " + title +
                "\nAutor: " + author.getNombre() +
                "\nIdioma: " + language +
                "\nDescargas: " + downloads +
                "\n--------------------------";
    }
}

