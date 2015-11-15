package Controller;

import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.before;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Controller {

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

    public static void getHomepage(){

    }
}
