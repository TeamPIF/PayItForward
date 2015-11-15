package Controller;

import Data.Homepage.Available;
import Data.Homepage.Donation;
import Data.Homepage.Served;
import JDBC.Receive;
import com.google.gson.Gson;

import javax.accessibility.AccessibleValue;

import static spark.Spark.get;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Homepage extends Controller{
    public void getdonated(){
        enableCORS("*", "*", "*");
        get("/homepage/donated", (request, response) -> {
            Donation donation = new Donation();
            donation.setSum(Receive.totalMealsDonated());
            Gson gson = new Gson();
            response.body(gson.toJson(donation));
            return response.body();
        });
    }

    public void getserved(){
        enableCORS("*", "*", "*");
        get("/homepage/served", (request, response) -> {
            Served served = new Served();
            served.setSum(Receive.totalMealsServed());
            Gson gson = new Gson();
            response.body(gson.toJson(served));
            return response.body();
        });
    }

    public void getavailable(){
        enableCORS("*", "*", "*");
        get("/homepage/available_all", (request, response) -> {
            Available available = new Available();
            available.setSum(Receive.currentlyAvailable());
            Gson gson = new Gson();
            response.body(gson.toJson(available));
            return response.body();
        });
    }
}
