package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Update extends Query {
    final static String TOTAL_MEALS_DONATED = "select COUNT(donation_id) from Donations";
    final static String TOTAL_MEALS_SERVED = "select COUNT(claim_id) from Claims";

    public static void donations(String business_id, String donation_id, String donor_id){
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            stmt.executeQuery(TOTAL_MEALS_DONATED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
