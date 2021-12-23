package com.itvdn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        Person person = new Person();
        person.setName("Ivan");
        person.setAge(28);
        person.setGender("Male");

        commitPerson(person);
    }

    private static void commitPerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();
        session.close();
    }
}
