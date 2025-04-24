package cl.duoc.cmartinez.bookstore.domain;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
  private String title;
  private String author;
  private String isbn;
  private String publisher;
  private LocalDate publicationDate;
  private String edition;
  private String language;
  private int numberOfPages;
  private List<String> genres;
  private int totalCopies;
  private int availableCopies;
  private String shelfLocation;
  private String summary;
}
