package com.work;

import com.work.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Experimenting with usage of Session.update(). This class shows that if
 * ojb1 is already attached to a session and then if another object with
 * same identifier as obj2 is used as argument in Session.update then
 * NonUniqueObjectException is thrown by Session.update() method.
 */
public class UpdateException {

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
            student.setEmail("anuroop10@gmail.com");
            session.update(student);

            Student anotherStudent = new Student();
            anotherStudent.setId(id);
            student.setEmail("anuroop11@gmail.com");
            session.update(anotherStudent);

            // commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}