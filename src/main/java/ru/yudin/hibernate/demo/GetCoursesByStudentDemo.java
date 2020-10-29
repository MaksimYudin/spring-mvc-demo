package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.*;


public class GetCoursesByStudentDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .addAnnotatedClass(Student.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;

            Student student = session.get(Student.class, id);

            System.out.println(student);
            System.out.println(student.getCourses());

            session.getTransaction().commit();

        } finally {

            session.close();

            sessionFactory.close();

        }

    }


}
