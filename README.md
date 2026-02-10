#  Desafío Books API

Proyecto desarrollado en **Java con Spring Boot** que consume la API pública **Gutendex** para consultar libros clásicos, autores e información relacionada, y persiste los datos en una base de datos **PostgreSQL**.

El proyecto se ejecuta desde consola y está enfocado en el aprendizaje de:
- Consumo de APIs REST
- Mapeo de JSON con Jackson
- Persistencia con JPA / Hibernate
- Uso de PostgreSQL
- Arquitectura en capas (Controller / Service / Repository)

---

##  Tecnologías utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Jackson
- Maven

---

##  API utilizada

- **Gutendex API**

  https://gutendex.com/books/


---

##  Funcionalidades

-  Buscar libros por título desde la API
-  Guardar libros y autores en la base de datos
-  Listar libros registrados
-  Listar autores
-  Filtrar libros por idioma
-  Mostrar estadísticas de descargas
-  Consultar autores vivos en un año específico

---

##  Estructura del proyecto

com.aluracursos.desafiobooksAPI
│
├── dto → Mapeo del JSON de la API
├── model → Entidades JPA
├── repository → Repositorios JPA
├── service → Lógica de negocio y consumo de API
├── principal → Menú por consola
└── DesafioBooksApiApplication.java

## Autor

Abraham Velázquez Carmona
Ingeniería en Sistemas Computacionales
