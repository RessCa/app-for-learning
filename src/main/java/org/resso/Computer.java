package org.resso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    private Developer owner;

    public Computer(String computerType, String cpu, String gpu, int ramGB, int diskGB, Developer owner) {
        this.computerType = computerType;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ramGB = ramGB;
        this.diskGB = diskGB;
        this.owner = owner;
    }

    public Computer(String computerType, String cpu, String gpu, int ramGB, int diskGB) {
        this.computerType = computerType;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ramGB = ramGB;
        this.diskGB = diskGB;
    }
}