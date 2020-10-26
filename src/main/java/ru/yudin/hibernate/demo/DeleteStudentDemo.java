package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Student;


public class DeleteStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            Integer studentId = 1;

            session.beginTransaction();

            Student student  = session.get(Student.class, studentId);

            session.delete(student);

            session.getTransaction().commit();


            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete from Student where id = 2").executeUpdate();

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }


}
