package Controller;
import com.google.gson.Gson;

import static spark.Spark.before;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Controller {
    public static Gson gson = new Gson();

    protected static void enableCORS(final String origin, final String methods, final String headers) {
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", origin);
            response.header("Access-Control-Request-Method", methods);
            response.header("Access-Control-Allow-Headers", headers);
        });
    }
}
