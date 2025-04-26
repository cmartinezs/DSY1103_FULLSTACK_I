package cl.duoc.cmartinez.bookstore.controller;

import cl.duoc.cmartinez.bookstore.controller.response.MessageResponse;
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
  public ResponseEntity<MessageResponse> createBook(@RequestBody Book request) {
    String isbn = request.getIsbn();
    for (Book book : books) {
      if (book.getIsbn().equals(isbn)) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new MessageResponse("Error: Book already exists"));
      }
    }
    books.add(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{isbn}")
  public ResponseEntity<MessageResponse> replaceBook(
          @PathVariable String isbn,
          @RequestBody Book request) {
    int count = 0;
    for (Book book : books) {
      if (book.getIsbn().equals(isbn)) {
        break;
      }
      count++; // count = count + 1
    }

    if (count == books.size()) {
      return ResponseEntity.notFound().build();
    }

    books.set(count, request);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new MessageResponse("Book was replaced"));
  }

  @PutMapping("/{isbn}/index")
  public ResponseEntity<MessageResponse> replaceBookIndex(
          @PathVariable String isbn,
          @RequestBody Book request) {
    Book found = null;
    for (Book book : books) {
      if (book.getIsbn().equals(isbn)) {
        found = book;
        break;
      }
    }

    int index = books.indexOf(found);

    if (index == -1) {
      return ResponseEntity.notFound().build();
    }

    books.set(index, request);

    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new MessageResponse("Book was replaced"));
  }
}
