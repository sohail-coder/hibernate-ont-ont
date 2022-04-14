package many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Course course = new Course("java language");
            System.out.println("Saving the course: "+course);
            session.save(course);
            Student student1 = new Student("ravi","peram","ravi@gmail.com");
            Student student2 = new Student("raju","peram","raju@gmail.com");

            System.out.println("Saving the students: ");
            session.save(student1);
            session.save(student2);

            course.addStudent(student1);
            course.addStudent(student2);



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
