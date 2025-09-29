package org.resso;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
    private String name;
    private int age;
    private String language;
}
