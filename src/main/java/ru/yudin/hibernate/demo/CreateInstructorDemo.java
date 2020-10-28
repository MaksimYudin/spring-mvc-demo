package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Course;
import ru.yudin.hibernate.demo.entity.Instructor;
import ru.yudin.hibernate.demo.entity.InstructorDetail;
import ru.yudin.hibernate.demo.entity.Student;


public class CreateInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            InstructorDetail instructorDetail =
                    new InstructorDetail("www.youtube.com", "it");

            Instructor instructor = new Instructor("max", "yudin", "do@email.com");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

        } finally {

            session.close();

            sessionFactory.close();

        }

    }


}
