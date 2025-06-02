package cl.duoc.cmartinez.authentication.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "username", updatable = false, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", updatable = false, nullable = false)
    private String email;

    @Column(name = "validation_code")
    private String validationCode;

    @Column(name = "validated", nullable = false)
    private boolean validated;
}
