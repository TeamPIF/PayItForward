/**
 * Created by EvanKing on 11/14/15.
 */
import Controller.*;
import JDBC.Receive;
import JDBC.Update;

import java.util.ArrayList;

import static spark.Spark.before;

public class Main {

    protected static void enableCORS(final String origin, final String methods, final String headers) {
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
        });
    }

    public static void main(String[] args) {
//        enableCORS("*", "*", "*");
//
//        Donate donate = new Donate();
//        donate.postDonation();
//
//        Homepage homepage = new Homepage();
//        homepage.getDonated();
//        homepage.getServed();
//        homepage.getAvailable();
//        homepage.getPartners();
//
//        Partners partners = new Partners();
//        partners.getDonatedByBusiness();
//
//        Register register = new Register();
//        register.postBusiness();
//
//        Stories stories = new Stories();
//        stories.postThankYou();
//
//        Tablet tablet = new Tablet();
//        tablet.postDonation();
          ArrayList<Integer> list =  Receive.businesses();
        System.out.println(list.toString());
    }
}
