package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Query {
    final static String connectionUrl = "jdbc:mysql://localhost:3306/testdatabase";
    final static String connectionUser = "foodforchange";
    final static String connectionPassword = "Chelseaforchange8";
    String query;

    public Query(String query) {
        this.query = query;
    }

    public int getData(){
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                sum = 0;
                String id = rs.getString("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println("ID: " + id + ", First Name: " + firstName
                        + ", Last Name: " + lastName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

}
