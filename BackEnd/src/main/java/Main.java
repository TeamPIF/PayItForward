/**
 * Created by EvanKing on 11/14/15.
 */
import Controller.Homepage;
import Controller.Partners;

public class Main {

    public static void main(String[] args) {

        Homepage homepage = new Homepage();
        homepage.getDonated();
        homepage.getServed();
        homepage.getAvailable();
        homepage.getPartners();

        Partners partners = new Partners();
        partners.getDonatedByBusiness();
    }
}
