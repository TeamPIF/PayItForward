/**
 * Created by EvanKing on 11/14/15.
 */
import Controller.Homepage;
import Controller.Partners;

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
        enableCORS("*","*","*");
        Homepage homepage = new Homepage();
        homepage.getDonated();
        homepage.getServed();
        homepage.getAvailable();
        homepage.getPartners();

        Partners partners = new Partners();
        partners.getDonatedByBusiness();
    }
}
