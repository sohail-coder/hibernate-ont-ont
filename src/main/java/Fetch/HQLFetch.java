package Fetch;

import onetomany.Course;
import onetomany.Instructor;
import onetomany.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLFetch {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            int theId=1;
            Query<Instructor> query =session.createQuery("select i from Instructor i "+
                    "JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
            query.setParameter("theInstructorId",theId);

            Instructor tempInstructor=query.getSingleResult();


            System.out.println(tempInstructor);

            System.out.println("courses\n");

            System.out.println(tempInstructor.getCourses());

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
