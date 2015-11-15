/**
 * Created by EvanKing on 11/14/15.
 */
import Controller.Homepage;
import com.google.gson.Gson;
import sectors.Donation;
import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class HelloWorld {

    public static void main(String[] args) {
        Homepage homepage = new Homepage();
        homepage.getdonated();
        homepage.getserved();
        homepage.getavailable();
    }
}