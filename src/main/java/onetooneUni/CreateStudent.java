package onetooneUni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {
    public static void main(String[] args) {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/xyz","eat  code  sleep  repeat");
            Instructor instructor = new Instructor("sohail","shaik","sonu@gmail.com");
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
            System.out.println("Saving");
            session.save(instructor);
            System.out.println("debug");
            session.getTransaction().commit();
            System.out.println("saved!! Done");


        }
        catch (Exception exc){
            factory.close();
            System.out.println("hi");
        }
    }
}
