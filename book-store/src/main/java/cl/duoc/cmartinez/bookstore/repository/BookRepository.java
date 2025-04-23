package cl.duoc.cmartinez.bookstore.repository;

import cl.duoc.cmartinez.bookstore.domain.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookRepository {
  private static final List<Book> books = new ArrayList<>();

  static {
    books.addAll(
        List.of(
            Book.builder()
                .title("El Principito")
                .author("Antoine de Saint-Exupéry")
                .isbn("9789566159629")
                .numberOfPages(96)
                .totalCopies(3)
                .availableCopies(3)
                .publisher("Reynal & Hitchcock")
                .publicationDate(LocalDate.of(1943, 4, 6))
                .edition("1ª edición")
                .language("Español")
                .genres(List.of("Ficción", "Infantil"))
                .shelfLocation("Pasillo A – Estante 1 – Nivel 2")
                .summary(
                    "Un piloto perdido en el desierto encuentra a un joven príncipe de otro planeta.")
                .build(),
            Book.builder()
                .title("Si lo crees, lo creas")
                .author("Brian Tracy y Christina Stein")
                .isbn("9789563256789")
                .numberOfPages(240)
                .totalCopies(2)
                .availableCopies(2)
                .publisher("Aguilar")
                .publicationDate(LocalDate.of(2011, 5, 1))
                .edition("Edición revisada")
                .language("Español")
                .genres(List.of("Autoayuda", "Negocios"))
                .shelfLocation("Pasillo B – Estante 3 – Nivel 1")
                .summary(
                    "Estrategias para reprogramar la mente y alcanzar el éxito personal y profesional.")
                .build(),
            Book.builder()
                .title("Papelucho y el marciano")
                .author("Marcela Paz")
                .isbn("9789563495768")
                .numberOfPages(144)
                .totalCopies(4)
                .availableCopies(4)
                .publisher("Mimbre Editorial")
                .publicationDate(LocalDate.of(1955, 7, 15))
                .edition("2ª edición")
                .language("Español")
                .genres(List.of("Infantil", "Aventura"))
                .shelfLocation("Pasillo C – Estante 2 – Nivel 4")
                .summary(
                    "Papelucho y sus amigos investigan la llegada de un curioso visitante marciano.")
                .build(),

            // Saga de El Señor de los Anillos
            Book.builder()
                .title("La Comunidad del Anillo")
                .author("J.R.R. Tolkien")
                .isbn("9780261103573")
                .numberOfPages(423)
                .totalCopies(5)
                .availableCopies(5)
                .publisher("Allen & Unwin")
                .publicationDate(LocalDate.of(1954, 7, 29))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Fantasía", "Aventura"))
                .shelfLocation("Pasillo D – Estante 1 – Nivel 1")
                .summary(
                    "Frodo Bolsón hereda un anillo que podría condenar a la Tierra Media y parte en misión para destruirlo.")
                .build(),
            Book.builder()
                .title("Las Dos Torres")
                .author("J.R.R. Tolkien")
                .isbn("9780618129110")
                .numberOfPages(352)
                .totalCopies(5)
                .availableCopies(5)
                .publisher("Allen & Unwin")
                .publicationDate(LocalDate.of(1954, 11, 11))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Fantasía", "Aventura"))
                .shelfLocation("Pasillo D – Estante 1 – Nivel 2")
                .summary(
                    "La compañía se divide y enfrentan nuevos peligros en su viaje hacia Mordor.")
                .build(),
            Book.builder()
                .title("El Retorno del Rey")
                .author("J.R.R. Tolkien")
                .isbn("9780618129158")
                .numberOfPages(416)
                .totalCopies(5)
                .availableCopies(5)
                .publisher("Allen & Unwin")
                .publicationDate(LocalDate.of(1955, 10, 20))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Fantasía", "Aventura"))
                .shelfLocation("Pasillo D – Estante 1 – Nivel 3")
                .summary("La gran batalla por la Tierra Media y el destino final del Anillo Único.")
                .build(),

            // Stephen King
            Book.builder()
                .title("Carrie")
                .author("Stephen King")
                .isbn("9780307743664")
                .numberOfPages(199)
                .totalCopies(3)
                .availableCopies(3)
                .publisher("Doubleday")
                .publicationDate(LocalDate.of(1974, 4, 5))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Terror", "Ficción"))
                .shelfLocation("Pasillo E – Estante 2 – Nivel 1")
                .summary(
                    "La historia de una joven con poderes telequinéticos que enfrenta el acoso escolar.")
                .build(),
            Book.builder()
                .title("IT")
                .author("Stephen King")
                .isbn("9781501142970")
                .numberOfPages(1138)
                .totalCopies(2)
                .availableCopies(2)
                .publisher("Viking Press")
                .publicationDate(LocalDate.of(1986, 9, 15))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Terror", "Suspense"))
                .shelfLocation("Pasillo E – Estante 2 – Nivel 2")
                .summary(
                    "Un grupo de niños debe enfrentarse a una entidad maligna que adopta la forma de un payaso.")
                .build(),

            // Programación
            Book.builder()
                .title("Effective Java")
                .author("Joshua Bloch")
                .isbn("9780134685991")
                .numberOfPages(416)
                .totalCopies(4)
                .availableCopies(4)
                .publisher("Addison-Wesley")
                .publicationDate(LocalDate.of(2018, 1, 6))
                .edition("3ª edición")
                .language("Inglés")
                .genres(List.of("Programación", "Java"))
                .shelfLocation("Pasillo P – Estante 5 – Nivel 1")
                .summary("Guía de buenas prácticas para el desarrollo en Java.")
                .build(),
            Book.builder()
                .title("Clean Code")
                .author("Robert C. Martin")
                .isbn("9780132350884")
                .numberOfPages(464)
                .totalCopies(4)
                .availableCopies(4)
                .publisher("Prentice Hall")
                .publicationDate(LocalDate.of(2008, 8, 1))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Programación", "Buenas prácticas"))
                .shelfLocation("Pasillo P – Estante 5 – Nivel 2")
                .summary("Manual para escribir código limpio, legible y mantenible.")
                .build(),
            Book.builder()
                .title("Design Patterns: Elements of Reusable Object-Oriented Software")
                .author("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides")
                .isbn("9780201633610")
                .numberOfPages(395)
                .totalCopies(3)
                .availableCopies(3)
                .publisher("Addison-Wesley")
                .publicationDate(LocalDate.of(1994, 10, 31))
                .edition("1ª edición")
                .language("Inglés")
                .genres(List.of("Programación", "Patrones de diseño"))
                .shelfLocation("Pasillo P – Estante 5 – Nivel 3")
                .summary("Clásico sobre 23 patrones de diseño para software orientado a objetos.")
                .build()));
  }

  public static List<Book> findAll() {
      return books;
  }
}
