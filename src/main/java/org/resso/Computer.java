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
@Table(name="computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String computerType;
    private String cpu;
    private String gpu;
    private int ramGB;
    private int diskGB;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer owner;

    public Computer(String computerType, Developer owner, int diskGB, int ramGB, String gpu, String cpu) {
        this.computerType = computerType;
        this.owner = owner;
        this.diskGB = diskGB;
        this.ramGB = ramGB;
        this.gpu = gpu;
        this.cpu = cpu;
    }
}