/**
 * Created by EvanKing on 11/14/15.
 */
import Controller.Homepage;
import Controller.Partners;

public class HelloWorld {

    public static void main(String[] args) {
        enableCORS("*", "*", "*");
        get("/hello", (req, res) -> "Hello World Confirm");
        get("/hello", (req, res) -> "{\"message\":\"Hello there, wayfaring stranger. " +
                "If you’re reading this then you probably didn’t see our blog post a " +
                "couple of years back announcing that this API would go away: " +
                "http://git.io/17AROg Fear not, you should be able to get what you need from " +
                "the shiny new Events API instead.\",\"documentation_url\":\"https://developer.github.com/v3/activity/events/#list-public-events\"}");
        Homepage homepage = new Homepage();
        homepage.getDonated();
        homepage.getServed();
        homepage.getAvailable();
        homepage.getPartners();

        Partners partners = new Partners();
        partners.getDonatedByBusiness();
        backend
    }
}
