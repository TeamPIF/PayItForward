package JDBC;


import java.sql.*;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Update extends Query {
    final static String INSERT_DONATION = "insert into Donation (id, business_id, donor_id)" +
            "values (?, ?, ?);";
    final static String INSERT_CLAIM = "insert into Claim (id, business_id)" +
            "values (?, ?);";
    final static String INSERT_BUSINESS = "insert into Business (id, name, address)" +
            "values (?, ?, ?);";
    final static String INSERT_CREDENTIALS = "insert into Credentials (business_id, email, password)" +
            "values (?, ?, ?);";
    final static String INSERT_THANK_YOU = "insert into Thank_You (id, name, message)" +
            "values (?, ?, ?);";

    public static void donation(String id, String business_id, String donor_id) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_DONATION);
            preparedStmt.setString(1, business_id);
            preparedStmt.setString(2, id);
            preparedStmt.setString(3, donor_id);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void claim(String id, String business_id) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_CLAIM);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, business_id);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void business(String id, String name, String address, String email, String password) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_BUSINESS);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, address);
            preparedStmt.executeQuery();

            PreparedStatement preparedStmt2 = conn.prepareStatement(INSERT_CREDENTIALS);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, email);
            preparedStmt.setString(3, password);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void thank_you(String id, String name, String message) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(INSERT_THANK_YOU);
            preparedStmt.setString(1, id);
            preparedStmt.setString(2, name);
            preparedStmt.setString(3, message);
            preparedStmt.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
