package com.work;

import com.work.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        // Create Session factory

        try (SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory()) {

            Transaction tx = null;

            // Idiom to use transactions.
            try (Session session = factory.getCurrentSession()) {
                Student anuroop = new Student("F1", "L1", "e1@gmail.com");

                tx = session.beginTransaction();

                session.save(anuroop);

                tx.commit();

                System.out.println("Student saved.");

            } catch (Exception e) {
                if (tx != null) tx.rollback();
            }
        }
    }
}
    