package JDBC;


import java.sql.*;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Update extends Query {
    final static String INSERT_DONATION = "insert into Donation (business_id, donor_id)" +
            "values (?, ?);";
    final static String INSERT_CLAIM = "insert into Claim (business_id)" +
            "values (?);";
    final static String INSERT_BUSINESS = "insert into Business (name, address)" +
            "values (?, ?);";
    final static String INSERT_CREDENTIALS = "insert into Credentials (business_id, email, password)" +
            "values (?, ?, ?);";
    final static String INSERT_THANK_YOU = "insert into Thank_You (name, message)" +
            "values (?, ?);";

    public static void donation(String business_id, String donor_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_DONATION);
            preparedStmt.setString(1, business_id);
            preparedStmt.setString(2, donor_id);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void claim(String business_id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_CLAIM);
            preparedStmt.setString(1, business_id);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void credentials(String bid, String email, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_CREDENTIALS);
            preparedStmt.setString(1, bid);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, password);
            preparedStmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void business(String name, String address, String email, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_BUSINESS);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, address);
            preparedStmt.executeQuery();

            credentials(Integer.toString(Receive.bid(email)), email, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void thank_you(String name, String message) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(jdbcUrl);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_THANK_YOU);
            preparedStmt.setString(1, name);
            preparedStmt.setString(2, message);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
