package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Instructor;
import ru.yudin.hibernate.demo.entity.InstructorDetail;


public class DeleteInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            int id = 1;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, id);

            if (instructor != null)
                session.delete(instructor);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }


}
