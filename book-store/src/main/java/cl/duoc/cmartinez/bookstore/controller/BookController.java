package cl.duoc.cmartinez.bookstore.controller;

import cl.duoc.cmartinez.bookstore.domain.Book;
import cl.duoc.cmartinez.bookstore.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  List<Book> books;

  public BookController() {
    books = BookRepository.findAll();
  }

  @GetMapping
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(books);
  }

  @GetMapping("/{isbn}")
  public ResponseEntity<Book> getBook(@PathVariable String isbn) {
    for (Book book : books) {
      if (book.getIsbn().equals(isbn)) {
        return ResponseEntity.ok(book);
      }
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<Void> createBook(@RequestBody Book book) {
    books.add(book);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
