package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Student;


public class ReadStudentDemo {
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

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Student savedStudent  = session.get(Student.class, tempStudent.getId());

            System.out.println(savedStudent);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }


}
