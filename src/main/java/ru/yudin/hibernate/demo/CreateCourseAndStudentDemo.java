package ru.yudin.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.yudin.hibernate.demo.entity.*;


public class CreateCourseAndStudentDemo {
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

            Course course = new Course("java programming");
            session.save(course);

            Student student1 = new Student("max", "yudin", "do@mail.ru");
            Student student2 = new Student("nick", "kozlov", "nk@mail.ru");

            course.addStudent(student1);
            course.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();

        } finally {

            session.close();

            sessionFactory.close();

        }

    }


}
