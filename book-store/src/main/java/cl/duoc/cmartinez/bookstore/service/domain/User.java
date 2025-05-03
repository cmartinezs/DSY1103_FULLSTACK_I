package cl.duoc.cmartinez.bookstore.service.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String fullName;
}
