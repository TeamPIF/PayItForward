/**
 * Created by EvanKing on 11/14/15.
 */
import com.google.gson.Gson;
import sectors.Donation;
import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class HelloWorld {

    private static void enableCORS(final String origin, final String methods, final String headers) {
        before(new Filter() {
            @Override
            public void handle(Request request, Response response) throws Exception {
                response.header("Access-Control-Allow-Origin", origin);
                response.header("Access-Control-Request-Method", methods);
                response.header("Access-Control-Allow-Headers", headers);
            }
        });
    }

    public static void main(String[] args) {
//        enableCORS("*", "*", "*");
//        get("/hello", (req, res) -> "Hello World Confirm");

        Donation d = new Donation(12, new java.sql.Timestamp(new java.util.Date().getTime()), "test");

        Gson gson = new Gson();

        String json = gson.toJson(d);

        System.out.println(json);
    }
}