package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Instructor;
import ru.yudin.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate_1to1uni.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            int id = 2;

            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }

    }


}
