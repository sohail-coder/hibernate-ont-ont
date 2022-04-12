import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass().buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();

            session.getTransaction().commit();

            session.close();

        }
        catch (Exception exc){
            factory.close();
            System.out.println("hi");
        }
    }
}
