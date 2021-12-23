package com.itvdn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Ivan");
        person.setAge(28);
        person.setGender("Male");

        commitEntity(person);
    }

    private static void commitEntity(Person person) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();
        session.close();
    }
}
