package OneToManyUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DemoApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Course course = new Course("java language");

            course.add(new Review("loved it cool course"));
            course.add(new Review("Fake, no legitimate content"));
            course.add(new Review("Marvelous, absolutely insane"));

            System.out.println(course);
            System.out.println();
            System.out.println(course.toString());

            session.save(course);

            System.out.println("done 1");
            session.getTransaction().commit();
            System.out.println("done 2");
            System.out.println(course.getReviews());

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
