package cl.duoc.cmartinez.cinemasubsidiaries.repository.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subsidiaries")
public class SubsidiaryJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Integer id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "address", nullable = false, unique = true)
    private String address;
    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    @Column(name = "capacity", nullable = false, precision = 3)
    private Integer capacity;
    @Column(name = "active", nullable = false)
    private boolean active;
}
