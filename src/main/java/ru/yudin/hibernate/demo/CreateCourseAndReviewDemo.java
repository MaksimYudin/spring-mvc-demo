package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.Course;
import ru.yudin.hibernate.demo.entity.Instructor;
import ru.yudin.hibernate.demo.entity.InstructorDetail;
import ru.yudin.hibernate.demo.entity.Review;


public class CreateCourseAndReviewDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .addAnnotatedClass(Review.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Course course = new Course("java programming");

            course.addReview(new Review(("good")));
            course.addReview(new Review(("bad")));
            course.addReview(new Review(("cool")));

            session.save(course);

            session.getTransaction().commit();

        } finally {

            session.close();

            sessionFactory.close();

        }

    }


}
