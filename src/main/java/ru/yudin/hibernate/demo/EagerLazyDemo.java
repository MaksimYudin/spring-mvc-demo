package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.yudin.hibernate.demo.entity.Course;
import ru.yudin.hibernate.demo.entity.Instructor;
import ru.yudin.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                                        .configure("hibernate.cfg.xml")
                                        .addAnnotatedClass(Instructor.class)
                                        .addAnnotatedClass(InstructorDetail.class)
                                        .addAnnotatedClass(Course.class)
                                        .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;

            Query<Instructor> query =
                    session.createQuery("select i from Instructor i "
                                            + "JOIN FETCH i.courses "
                                            + "where i.id = :instructorId");

            query.setParameter("instructorId", id);

            Instructor instructor = query.getSingleResult();

            //Instructor instructor = session.get(Instructor.class, id);

            System.out.println("Instructor: " + instructor);

            //System.out.println("Courses: " + instructor.getCourses());

            session.getTransaction().commit();

            // just for testing lazy loading after session close
            session.close();
            // **
            System.out.println("Courses: " + instructor.getCourses());

        } finally {

            session.close();

            sessionFactory.close();

        }

    }


}
