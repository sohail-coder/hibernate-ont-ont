package onetooneUni;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false&serverTimeZone=UTC";
        String user="hbstudent1";
        String pass="Sohail@99";

        try {
            System.out.println("connecting to : "+ jdbcURL);
            Connection connection = DriverManager.getConnection(jdbcURL,user,pass);
            System.out.printf("Connection successful");
        }
        catch (Exception exc){
            exc.getMessage();
        }

    }
}
