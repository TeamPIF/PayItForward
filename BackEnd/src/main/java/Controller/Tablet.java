package Controller;

import Data.Homepage.Donate.Donation;
import Data.Homepage.Tablet.Claim;
import JDBC.Receive;
import JDBC.Update;

import static spark.Spark.*;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Tablet extends Controller{
    public void postDonation(){
        post("/tablet/donation", (request, response) -> {
            String req = request.body();
            Donation donation = gson.fromJson(req, Donation.class); 
            int bid = Receive.bid(donation.getEmail());
            Update.donation(Integer.toString(bid), null);
            response.status(200);
            return response.body();
        });
    }

    public void postClaim() {
        post("/tablet/claim", (request, response) -> {
            String req = request.body();
            Claim claim = gson.fromJson(req, Claim.class);
            int bid = Receive.bid(claim.getEmail());
            Update.claim(Integer.toString(bid));
            response.status(200);
            return response.body();
        });
    }
}
