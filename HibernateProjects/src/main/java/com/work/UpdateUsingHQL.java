package com.work;

import com.work.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateUsingHQL {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // Get a student.
            int id = 1;
            System.out.println("Getting student with key " + id);

            // start a transaction
            session.beginTransaction();

            Student student = session.get(Student.class, id);
            System.out.println("DEBUG: " + student);

            // commit transaction
            session.getTransaction().commit();

            // now get a new session and start transaction
            session = factory.getCurrentSession();

            session.beginTransaction();

            // Update all student emails to foo@gmail.com
            session.createQuery("UPDATE Student SET email = 'foo@gmail.com'").executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}