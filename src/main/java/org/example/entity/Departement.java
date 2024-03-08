package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor
public class Departement {
    @Id
    private int id;

    private String nom;

    @OneToMany(mappedBy = "departement",cascade = CascadeType.ALL)
    private List<Employee> employees;

}
