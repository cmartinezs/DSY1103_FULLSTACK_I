package cl.duoc.cmartinez.bookstore.controller;

import cl.duoc.cmartinez.bookstore.controller.response.MessageResponse;
import cl.duoc.cmartinez.bookstore.service.BookService;
import cl.duoc.cmartinez.bookstore.service.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
  @Autowired
  private BookService bookService;

  @GetMapping
  public ResponseEntity<List<Book>> getBooks() {
    return ResponseEntity.ok(bookService.getBooks());
  }

  @GetMapping("/{isbn}")
  public ResponseEntity<Book> getBook(@PathVariable String isbn) {
    Book found = bookService.getBook(isbn);
    if (found != null) {
      return ResponseEntity.ok(found);
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<MessageResponse> createBook(
          @RequestBody Book request) {
    boolean added = bookService.addBook(request);
    if(!added) {
      return ResponseEntity
              .status(HttpStatus.CONFLICT)
              .body(new MessageResponse("Error: Book already exists"));
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{isbn}")
  public ResponseEntity<MessageResponse> replaceBook(
          @PathVariable String isbn,
          @RequestBody Book request) {
    boolean replaced = bookService.replaceBook(isbn, request);
    if(!replaced) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new MessageResponse("Book was replaced"));
  }

  @DeleteMapping("/{isbn}")
  public ResponseEntity<MessageResponse> deleteBook(
          @PathVariable String isbn) {
    boolean deleted = bookService.deleteBook(isbn);
    if(!deleted) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(new MessageResponse("Book was deleted"));
  }
}
