package onetooneBi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            int id=1;

            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);
            System.out.println("instructor detgails: "+instructorDetail);
            System.out.println();
            Instructor instructor = instructorDetail.getInstructor();
            System.out.println("Instructor : "+instructor);
            System.out.println();
            session.getTransaction().commit();
            System.out.println("Done");


        }
        catch (Exception exc){

            exc.printStackTrace();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
