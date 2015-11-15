package Controller;

import Data.Homepage.Donation.Donation;
import JDBC.Update;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Donate {
    public void postDonation(){
        post("/donation/submit", (request, response) -> {
            Gson gson = new Gson();
            String req = request.body();
            Donation donation = gson.fromJson(req, Donation.class);
            Update.donation(donation.getBusiness_id(), donation.getDonor_id());
            response.body(req);
            response.status(200);
            return response.body();
        });
    }
}
