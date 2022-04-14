package onetomany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMainApp {
    public static void main(String[] args)  {


        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{

//        Instructor instructor= new Instructor("susan","public","susan@gmail.com");
//            InstructorDetail instructorDetail = new InstructorDetail("youtube.com","video games");
//            Course course = new Course("c language");
//        instructor.setInstructorDetail(instructorDetail);
//        instructor.add(course);
        session.beginTransaction();
       InstructorDetail instructorDetail = session.get(InstructorDetail.class,2);
       session.delete(instructorDetail);

//        session.save(instructor);

        session.getTransaction().commit();


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
