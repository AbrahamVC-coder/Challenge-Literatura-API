# Literatura API 📚

Java application that consumes the [Gutendex API](https://gutendex.com/) to search, 
persist, and query books and authors using a PostgreSQL database.

---

## 🛠 Tech Stack

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)

---

## ✨ Features

- 🔍 Search books by title consuming the **Gutendex external API**
- 💾 Persist books and authors in **PostgreSQL**
- 📋 List all books stored in the database
- 👤 List all authors stored in the database
- 🗓 Query authors alive during a specific year
- 🌐 Filter books by language

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/aluracursos/desafiob.../
│   │   ├── Principal/
│   │   │   └── Principal.java          # Main menu & app flow
│   │   ├── dto/
│   │   │   ├── AuthorDTO.java
│   │   │   ├── BookDTO.java
│   │   │   └── GutendexResponse.java   # API response mapping
│   │   ├── model/
│   │   │   ├── Author.java
│   │   │   ├── AuthorRepository.java
│   │   │   ├── Book.java
│   │   │   ├── BookRepository.java
│   │   │   ├── Datos.java
│   │   │   ├── DatosAutor.java
│   │   │   └── DatosLibros.java
│   │   ├── service/
│   │   │   ├── BookService.java
│   │   │   ├── ConsumoAPIlibros.java   # Gutendex API consumer
│   │   │   ├── ConvierteDatos.java     # JSON deserialization
│   │   │   └── IConvierteDatos.java    # Conversion interface
│   │   └── DesafiobooksApiApplication.java
│   └── resources/
│       └── application.properties
```

---

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- PostgreSQL running locally
- Maven

### Setup

```bash
# Clone the repository
git clone https://github.com/AbrahamVC-coder/Challenge-Literatura-API.git
cd Challenge-Literatura-API
```

Configure your database in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literaturdb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Run the application:

```bash
mvn spring-boot:run
```

---

## 🖥 How It Works

The app runs as an interactive console menu:

```
=== LITERATURA API ===
1 - Search book by title
2 - List registered books
3 - List registered authors
4 - List authors alive in a given year
5 - List books by language
0 - Exit
```

**Example — Search a book:**
```
Enter book title: Don Quijote
✔ Book found and saved: Don Quijote de la Mancha
  Author: Miguel de Cervantes (1547 - 1616)
  Language: es
  Downloads: 25431
```

---

## 🌐 External API

This project consumes [Gutendex](https://gutendex.com/) — a free REST API 
that provides metadata for over 70,000 public domain books from Project Gutenberg.

```
GET https://gutendex.com/books/?search={title}
```

---

## 👤 Author

**Abraham Velázquez Carmona**  
[LinkedIn](https://linkedin.com/in/abraham-velazquez-carmona) · [GitHub](https://github.com/AbrahamVC-coder)
