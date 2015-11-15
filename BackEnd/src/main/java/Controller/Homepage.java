package Controller;

import Data.Homepage.Homepage.Available;
import Data.Homepage.Homepage.Donation;
import Data.Homepage.Partners.NumPartners;
import Data.Homepage.Homepage.Served;
import JDBC.Receive;
import com.google.gson.Gson;


import static spark.Spark.get;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Homepage extends Controller{
    public void getDonated(){
        enableCORS("*", "*", "*");
        get("/homepage/donated", (request, response) -> {
            Donation donation = new Donation();
            donation.setSum(Receive.totalMealsDonated());
            Gson gson = new Gson();
            response.body(gson.toJson(donation));
            return response.body();
        });
    }

    public void getServed(){
        enableCORS("*", "*", "*");
        get("/homepage/served", (request, response) -> {
            Served served = new Served();
            served.setSum(Receive.totalMealsServed());
            Gson gson = new Gson();
            response.body(gson.toJson(served));
            return response.body();
        });
    }

    public void getAvailable(){
        enableCORS("*", "*", "*");
        get("/homepage/available_all", (request, response) -> {
            Available available = new Available();
            available.setSum(Receive.currentlyAvailable());
            Gson gson = new Gson();
            response.body(gson.toJson(available));
            return response.body();
        });
    }

    public void getPartners(){
        enableCORS("*", "*", "*");
        get("/homepage/num_partners", (request, response) -> {
            NumPartners numPartners = new NumPartners();
            numPartners.setSum(Receive.numPartners());
            Gson gson = new Gson();
            response.body(gson.toJson(numPartners));
            return response.body();
        });
    }
}
