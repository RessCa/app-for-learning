package org.resso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        Developer dev1 = new Developer("Bob", 22, "JS");
        Developer dev2 = new Developer("Rob", 32, "Swift");

        Computer comp1 = new Computer("PC", "intel i9 11900", "GeForce 1660", 16, 256);
        Computer comp2 = new Computer("Laptop", "intel i7 2700", "GeForce 660", 16, 516);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();



        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}