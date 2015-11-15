package Controller;

import Data.Homepage.Donation;
import com.google.gson.Gson;

import static spark.Spark.get;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Homepage extends Controller{
    public void getdonated(){
        enableCORS("*", "*", "*");
        get("/homepage/donated", (request, respond) -> {
            Donation donation = new Donation();
            Gson gson = new Gson();
            respond.body(gson.toJson(donation));
            return respond.body();
        });
    }

    public static void getserved(){
        enableCORS("*", "*", "*");
        get("/homepage/served", (request, respond) -> {
            Pages.Homepage homepage = new Pages.Homepage();
            Gson gson = new Gson();
            respond.body(gson.toJson(homepage));
            return respond.body();
        });
    }
}
