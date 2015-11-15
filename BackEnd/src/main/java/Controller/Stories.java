package Controller;

import Data.Homepage.Stories.ThankYou;
import JDBC.Update;
import com.google.gson.Gson;

import static spark.Spark.post;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Stories extends Controller{
    public void postThankYou() {
        post("/stories/submit", (request, response) -> {
            String req = request.body();
            ThankYou thankYou = gson.fromJson(req, ThankYou.class);
            Update.thank_you(thankYou.getName(), thankYou.getMessage());
            response.body(req);
            response.status(200);
            return response.body();
        });
    }
}
