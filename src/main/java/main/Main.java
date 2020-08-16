package main;

import main.entity.Course;
import main.entity.Student;
import main.entity.Subscription;
import main.entity.Teacher;
import main.enums.CourseType;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        checkCourse(session);
        checkTeacher(session);
        checkStudent(session);
        checkSubscription(session);
        session.close();
    }

    private static void checkCourse(Session session) {
        String hql = "SELECT c FROM Course c where c.type = \'" + CourseType.PROGRAMMING + "'";
        List<Course> list = session.createQuery(hql, Course.class).getResultList();
        list.forEach(System.err::println);
    }

    private static void checkTeacher(Session session) {
        String hql = "SELECT t FROM Teacher t WHERE t.id = 1";
        Teacher teacher = session.createQuery(hql, Teacher.class).getSingleResult();
        System.err.println(teacher);
    }

    private static void checkStudent(Session session) {
        String hql = "Select s from Student s where s.age > 20 and s.age < 23";
        List<Student> list = session.createQuery(hql, Student.class).getResultList();
        ;
        list.forEach(System.err::println);
    }

    private static void checkSubscription(Session session) {
        String hql = "Select s from Subscription s where s.key.student.id = 1";
        List<Subscription> list = session.createQuery(hql, Subscription.class).getResultList();
        list.forEach(System.err::println);
    }
}
