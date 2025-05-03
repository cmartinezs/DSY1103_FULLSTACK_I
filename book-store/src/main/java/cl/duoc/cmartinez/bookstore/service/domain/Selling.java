package cl.duoc.cmartinez.bookstore.service.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Selling {
    private int id;
    private String username;
    private String isbn;
    private LocalDate date;
}
