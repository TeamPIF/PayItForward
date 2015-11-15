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
    final static String TOTAL_MEALS_DONATED = "select COUNT(*) from Donation";
    final static String TOTAL_MEALS_SERVED = "select COUNT(*) from Claim";
    final static String BUSINESS_PASSWORD = "select password from Business where email = ?";
    final static String BUSINESS_AVAILABLE = "select Count(*) from Donation where business_id = ?";
    final static String COUNT_TIME = "select D.business_id as bid, month(D.donation_time) as Month, Count(D.business_id) as Sum from Donation D where D.business_id = ? " +
            "group by D.business_id, Month(D.donation_time)";
    final static String BUSINESSES = "select id from Business";
    final static String BID = "select id from Business where email = ?";
    final static String NUM_PARTNERS = "select Count(*) from Business";

    public static int totalMealsDonated() {
        int total = 0;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(TOTAL_MEALS_DONATED);
            if (rs.next()) total = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static int totalMealsServed() {
        int total = 0;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(TOTAL_MEALS_SERVED);
            if (rs.next()) total = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    public static String password(String email) {
        String password = null;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);
            PreparedStatement preparedStmt = conn.prepareStatement(BUSINESS_PASSWORD);
            preparedStmt.setString(1, email);
            ResultSet rs = preparedStmt.executeQuery();
            password = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

    //TODO
    private static Business countTimes(String business_id) {
        ArrayList<CountTime> list = null;
        Business business = null;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);

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

    //TODO
    public static ArrayList<Integer> businesses() {
        ArrayList<Integer> businesses = null;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(BUSINESSES);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for(int i=1; i<=columnsNumber; i++) {
                    businesses.add(rs.getInt(i));
                }
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

    public static int bid(String email) {
        int bid = 0;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);

            PreparedStatement preparedStmt = conn.prepareStatement(BID);
            preparedStmt.setString(1, email);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) bid = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bid;
    }

    public static int available(String bid) {
        int sum = 0;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);

            PreparedStatement preparedStmt = conn.prepareStatement(BUSINESS_AVAILABLE);
            preparedStmt.setString(1, bid);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) sum = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static int numPartners() {
        int sum = 0;
        try {
            Class.forName(DRIVER_NAME);
            Connection conn = DriverManager.getConnection(JBCCURL);

            PreparedStatement preparedStmt = conn.prepareStatement(NUM_PARTNERS);
            ResultSet rs = preparedStmt.executeQuery();
            if (rs.next()) sum = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }


    public static int currentlyAvailable() {
        int donations = totalMealsDonated();
        int claims = totalMealsServed();
        return claims > donations ? 0 : donations - claims;
    }


}
