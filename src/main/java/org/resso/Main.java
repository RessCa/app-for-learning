package org.resso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {

        final String url = String.format(
                "jdbc:postgresql://%s:%s/%s",
                System.getenv("DB_HOST"),
                System.getenv("DB_PORT"),
                System.getenv("POSTGRES_DB"));

        //JDBC configuration
        Configuration cfg = new Configuration().configure();
        cfg.setProperty("hibernate.connection.url", url);
        cfg.setProperty("hibernate.connection.username", System.getenv("POSTGRES_USER"));
        cfg.setProperty("hibernate.connection.password", System.getenv("POSTGRES_PASSWORD"));


        Developer dev1 = new Developer("Bob", 22, "JS");
        Developer dev2 = new Developer("Rob", 32, "Swift");

        Computer comp1 = new Computer("PC", "intel i9 11900", "GeForce 1660", 16, 256);
        Computer comp2 = new Computer("Laptop", "intel i7 2700", "GeForce 660", 16, 516);

        dev1.addComputer(comp1);
        dev2.addComputer(comp2);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Developer dev1 = session.find(Developer.class, 1);
//        Developer dev2 = session.find(Developer.class, 2);

        session.persist(dev1);
        session.persist(dev2);

        System.out.println(dev1);
        System.out.println(dev2);

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}