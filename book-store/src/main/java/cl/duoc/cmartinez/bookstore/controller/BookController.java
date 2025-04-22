package cl.duoc.cmartinez.bookstore.controller;

import cl.duoc.cmartinez.bookstore.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  List<Book> books;

  public BookController() {
    books = new ArrayList<>();
    books.add(new Book("El Principito", "Antoine de Saint-Exupéry", "9789566159629"));
    books.add(new Book("Si lo crees, lo creas", "Brian Tracy y Christina Stein", "9789563256789"));
    books.add(new Book("Papelucho y el marciano", "Marcela Paz", "9789563495768"));
  }

  @GetMapping
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(books);
  }

  @GetMapping("/{isbn}")
  public ResponseEntity<Book>
    getBook(@PathVariable String isbn) {

    for(Book book: books) {
      if(book.getIsbn().equals(isbn)) {
        return ResponseEntity.ok(book);
      }
    }

    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Void> createBook(
          @RequestBody Book book) {
    books.add(book);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
  }
}
