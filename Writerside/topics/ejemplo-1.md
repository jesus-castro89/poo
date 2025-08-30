# Ejemplo 1: El sistema de gestión de biblioteca

## Descripción

Un sistema de gestión de biblioteca debe permitir a los usuarios buscar, reservar y prestar libros. El sistema debe
incluir las siguientes clases:

* **Libro**: Representa un libro en la biblioteca. Atributos: título, autor, ISBN, año de publicación, estado (
  disponible, prestado). Métodos: prestar, devolver, reservar.
* **Usuario**: Representa a un usuario de la biblioteca. Atributos: nombre, ID de usuario, lista de libros prestados,
  lista de reservas. Métodos: registrar, iniciar sesión, cerrar sesión.
* **Biblioteca**: Representa la biblioteca en sí. Atributos: lista de libros, lista de usuarios. Métodos:
  agregar libro, eliminar libro, buscar libro, listar libros disponibles.
* **Préstamo**: Representa un préstamo de libro. Atributos: libro, usuario, fecha de préstamo, fecha de devolución.
  Métodos: crear préstamo, finalizar préstamo.
* **Reserva**: Representa una reserva de libro. Atributos: libro, usuario, fecha de reserva. Métodos: crear reserva,
  cancelar reserva.

## Diagrama de Clases

### 1. Identificación de Clases

- Libro(Book)
- Usuario(User)
- Biblioteca(Library)
- Préstamo(Loan)
- Reserva(Reservation)

```plantuml
@startuml
skinparam class{
    AttributeFontSize 18
    FontStyle bold
}

class Book{
}
class User{
}
class Library{
}
class Loan{
}
class Reservation
{
}
@enduml
```

### 2. Atributos y Métodos

```plantuml
@startuml
skinparam class{
    AttributeFontSize 18
    FontStyle bold
}
class Book{
    - title: String
    - author: String
    - isbn: String
    - publicationYear: int
    + Book(): void
    - Book(title: String, author: String, isbn: String, publicationYear: int): void
    - available: boolean
    + lend(): void
    + returnBook(): void
    + reserve(): void
}

class User{
    - name: String
    - userId: String
    - borrowedBooks: Book[]
    - reservations: Reservation[]
    + User(): void
    - User(name: String, userId: String): void
    - register(): void
    + login(): void
    + logout(): void
}
class Library{
    - books: Book[]
    - users: User[]
    + Library(): void
    + menu(): void
    - addBook(book: Book): void
    - removeBook(book: Book): void
    - searchBook(title: String): Book[]
    - listAvailableBooks(): Book[]
}
class Loan{
    - book: Book
    - user: User
    - loanDate: Date
    - returnDate: Date
    + Loan(book: Book, user: User, loanDate: Date): void
    + finalizeLoan(): void
}
class Reservation
{
    - book: Book
    - user: User
    - reservationDate: Date
    + Reservation(book: Book, user: User, reservationDate: Date): void
    + cancelReservation(): void
}
@enduml
```

### 3. Relaciones entre Clases

```plantuml
@startuml
skinparam class{
    AttributeFontSize 18
    ArrowFontSize 18
    FontStyle bold
}
class Book{
    - title: String
    - author: String
    - isbn: String
    - publicationYear: int
    + Book(): void
    - Book(title: String, author: String, isbn: String, publicationYear: int): void
    - available: boolean
    + lend(): void
    + returnBook(): void
    + reserve(): void
}

class User{
    - name: String
    - userId: String
    - borrowedBooks: Book[]
    - reservations: Reservation[]
    + User(): void
    - User(name: String, userId: String): void
    - register(): void
    + login(): void
    + logout(): void
}
class Library{
    - books: Book[]
    - users: User[]
    + Library(): void
    + menu(): void
    - addBook(book: Book): void
    - removeBook(book: Book): void
    - searchBook(title: String): Book[]
    - listAvailableBooks(): Book[]
}
class Loan{
    - book: Book
    - user: User
    - loanDate: Date
    - returnDate: Date
    + Loan(book: Book, user: User, loanDate: Date): void
    + finalizeLoan(): void
}
class Reservation
{
    - book: Book
    - user: User
    - reservationDate: Date
    + Reservation(book: Book, user: User, reservationDate: Date): void
    + cancelReservation(): void
}
Library "1" --- "0...*" Book : tiene >
Library "1" --- "0...*" User : tiene >
User "1" --- "0...*" Loan : realiza >
User "1" --- "0...*" Reservation : realiza >
Book "1" --- "0...*" Loan : es prestado en >
Book "1" --- "0...*" Reservation : es reservado en >
@enduml
```