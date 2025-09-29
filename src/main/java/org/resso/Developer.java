package org.resso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String language;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Computer> computers;

    public Developer(String name, int age, String language, List<Computer> computers) {
        this.name = name;
        this.age = age;
        this.language = language;
        this.computers = computers;
    }
}
