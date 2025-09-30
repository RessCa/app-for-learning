package org.resso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST) //mapped in Computer
    @ToString.Exclude
    private List<Computer> computers = new ArrayList<>();

    public Developer(String name, int age, String language) {
        this.name = name;
        this.age = age;
        this.language = language;
    }

    //adds computer to computers and sets computer owner field to this dev
    public void addComputer(Computer computer) {
        computers.add(computer);
        computer.setOwner(this);
    }
}
