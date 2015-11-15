package Controller;

import Data.Homepage.Donate.Donation;
import JDBC.Receive;
import JDBC.Update;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Donate {
    //TODO
    public void postDonation(){
        post("/donation/submit", (request, response) -> {
            Gson gson = new Gson();
            String req = request.body();
            Donation donation = gson.fromJson(req, Donation.class);
            int bid = Receive.bid(donation.getName());
            System.out.println(bid);
            Update.donation(Integer.toString(bid), donation.getDonor_id());
            response.status(200);
            return response.body();
        });
    }
}
