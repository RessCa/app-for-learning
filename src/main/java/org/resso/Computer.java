package org.resso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Computer {
    private String computerName;
    private String computerType;
    private String cpu;
    private String gpu;
    private int ramGB;
    private int diskGB;
}