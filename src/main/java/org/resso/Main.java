package org.resso;

public class Main {
    public static void main(String[] args) {

        Computer comp1 = new Computer("Comp1", "PC", "intel i9 11900", "GeForce 1660", 16, 256);
        Computer comp2 = new Computer("Comp2", "Laptop", "intel i7 2700", "GeForce 660", 16, 516);
        Computer comp3 = new Computer("Comp3", "AIO", "intel i5 8850", "Intel HD Graphic", 8, 516);

        Developer dev1 = new Developer("Bob", 22, "JS");
        Developer dev2 = new Developer("Rob", 32, "Swift");


    }
}