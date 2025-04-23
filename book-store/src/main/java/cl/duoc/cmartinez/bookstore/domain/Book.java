package cl.duoc.cmartinez.bookstore.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class Book {
  private final String title;
  private final String author;
  private final String isbn;
  private String publisher;
  private LocalDate publicationDate;
  private String edition;
  private String language;
  private final int numberOfPages;
  private List<String> genres;
  private final int totalCopies;
  private final int availableCopies;
  private String shelfLocation;
  private String summary;
}
