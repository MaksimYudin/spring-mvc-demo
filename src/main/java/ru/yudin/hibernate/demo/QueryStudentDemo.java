package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            List<Student> students = session.createQuery("from Student").getResultList();

            for (Student student : students)
                System.out.println(student);

            students = session.createQuery("from Student where firstName = 'max'").getResultList();

            for (Student student : students)
                System.out.println(student);

            students = session.createQuery("from Student s where s.firstName like 'ma%'").getResultList();

            for (Student student : students)
                System.out.println(student);

            session.getTransaction().commit();
            
        } finally {
            sessionFactory.close();
        }

    }


}
