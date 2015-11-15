package Controller;

import Data.Homepage.Register.Business;
import JDBC.Update;
import com.google.gson.Gson;

import static spark.Spark.*;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Register extends Controller{
    public void postBusiness() {
        post("/register/business", (request, response) -> {
            Gson gson = new Gson();
            String req = request.body();
            Business business = gson.fromJson(req, Business.class);
            Update.business(business.getName(), business.getAddress(), business.getEmail(), business.getPassword());
            response.status(200);
            return response.body();
        });
    }
}
