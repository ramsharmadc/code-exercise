package com.work;

import com.work.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Experimenting with usage of Session.update()
 */
public class UpdateAttachedEntity {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Student student;
        int id = 1;

        try (Session session = factory.getCurrentSession()) {
            // Get a student.

            System.out.println("Getting student with key " + id);

            // start a transaction
            session.beginTransaction();

            student = session.get(Student.class, id);

            student.setEmail("anuroop2@gmail.com");
            session.update(student);

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}