package onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCourse {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,1);
            Course course = new Course("c programming");
            Course course1 = new Course("python programming");

            instructor.add(course);
            instructor.add(course1);



            session.save(course);
            session.save(course1);

            session.getTransaction().commit();

        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }


}
