package cl.duoc.cmartinez.cinemasubsidiaries.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryEntity {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int capacity;
    private boolean active;
}
