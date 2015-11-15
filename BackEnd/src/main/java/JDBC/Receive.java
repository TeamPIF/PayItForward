package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Receive extends Query{
    final static String TOTAL_MEALS_DONATED = "select COUNT(donation_id) from Donations";
    final static String TOTAL_MEALS_SERVED = "select COUNT(claim_id) from Claims";

    public static int totalMealsDonated() {
        int total = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(TOTAL_MEALS_DONATED);
            total = rs.getInt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int totalMealsServed() {
        int total = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(TOTAL_MEALS_SERVED);
            total = rs.getInt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int currentlyAvailable(){
        return totalMealsDonated() - totalMealsServed();
    }

}
