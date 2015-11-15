package JDBC;

import HelperObject.Business;
import HelperObject.CountTime;
import Pages.Partners;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Receive extends Query {
    final static String TOTAL_MEALS_DONATED = "select COUNT(donation_id) from Donation";
    final static String TOTAL_MEALS_SERVED = "select COUNT(claim_id) from Claim";
    final static String BUSINESS_PASSWORD = "select password from Business where email = ?";
    final static String COUNT_TIME = "select D.business_id as bid, month(D.donation_time) as Month, Count(D.business_id) as Sum from Donation D where D.business_id = ? " +
            "group by D.business_id, Month(D.donation_time)";
    final static String BUSINESSES = "select id from Business";

    public static int totalMealsDonated() {
        int total = 0;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(TOTAL_MEALS_DONATED);
            total = rs.getInt(1);
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
            total = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static String password(String email) {
        String password = null;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(BUSINESS_PASSWORD);
            preparedStmt.setString(1, email);
            ResultSet rs = preparedStmt.executeQuery();
            password = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    private static Business countTimes(String business_id) {
        ArrayList<CountTime> list = null;
        Business business = null;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);

            PreparedStatement preparedStmt = conn.prepareStatement(COUNT_TIME);
            preparedStmt.setString(1, business_id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                business = new Business();
                business.setBusinessName(rs.getString("bid"));
                CountTime countTime = new CountTime();
                countTime.setCount(rs.getInt("Sum"));
                countTime.setTime(rs.getNString("Month"));
                list.add(countTime);
                business.setDonations(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return business;
    }

    private static ArrayList<Integer> businesses() {
        ArrayList<Integer> businesses = null;
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(BUSINESSES);
            while (rs.next()){
                businesses.add(rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return businesses;
    }

    public static Partners partners() {
        Partners partners = new Partners();
        ArrayList<Business> partnersData = new ArrayList<>();
        ArrayList<Integer> businesses = businesses();
        partnersData.addAll(businesses.stream().map(bid -> countTimes(Integer.toString(bid))).collect(Collectors.toList()));
        partners.setPartnersData(partnersData);
        return partners;
    }


    public static int currentlyAvailable() {
        int donations = totalMealsDonated();
        int claims = totalMealsServed();
        return claims > donations ? 0 : donations - claims;
    }


}
