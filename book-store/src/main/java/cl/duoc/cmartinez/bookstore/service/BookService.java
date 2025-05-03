package cl.duoc.cmartinez.bookstore.service;

import cl.duoc.cmartinez.bookstore.repository.BookRepository;
import cl.duoc.cmartinez.bookstore.service.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
  public List<Book> getBooks() {
    return BookRepository.findAll();
  }

  public Book getBook(String isbn) {
    return BookRepository.findByIsbn(isbn);
  }

  public boolean addBook(Book book) {
    String isbn = book.getIsbn();
    Book found = BookRepository.findByIsbn(isbn);
    if (found != null) {
      return false;
    }
    BookRepository.addBook(book);
    return true;
  }

  public boolean replaceBook(String isbn, Book request) {
    Book found = BookRepository.findByIsbn(isbn);
    if (found == null) {
      return false;
    }
    BookRepository.replaceBook(found, request);
    return true;
  }

  public boolean deleteBook(String isbn) {
    Book found = BookRepository.findByIsbn(isbn);
    if (found == null) {
      return false;
    }
    BookRepository.removeBook(found);
    return true;
  }
}
