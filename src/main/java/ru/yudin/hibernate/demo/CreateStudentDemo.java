package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.yudin.hibernate.demo.entity.Student;
import org.hibernate.cfg.Configuration;



public class CreateStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Student tempStudent = new Student("max", "yudin", "do@email.com");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }


}
