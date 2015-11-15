package Controller;

import Data.Homepage.Donation.Donation;
import Data.Homepage.Tablet.Claim;
import JDBC.Update;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Tablet extends Controller{
    public void postDonation(){
        post("/tablet/claim", (request, response) -> {
            String req = request.body();
            Donation donation = gson.fromJson(req, Donation.class);
            Update.donation(donation.getBusiness_id(), donation.getDonor_id());
            response.status(200);
            return response.body();
        });
    }

    public void postClaim() {
        post("/tablet/claim", (request, response) -> {
            String req = request.body();
            Claim claim = gson.fromJson(req, Claim.class);
            Update.claim(claim.getBusiness_id());
            response.status(200);
            return response.body();
        });
    }
}
