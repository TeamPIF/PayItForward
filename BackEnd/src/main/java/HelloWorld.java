/**
 * Created by EvanKing on 11/14/15.
 */
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
<<<<<<< HEAD
        enableCORS("*", "*", "*");
        get("/hello", (req, res) -> "Hello World Confirm");
=======
        get("/hello", (req, res) -> "{\"message\":\"Hello there, wayfaring stranger. " +
                "If you’re reading this then you probably didn’t see our blog post a " +
                "couple of years back announcing that this API would go away: " +
                "http://git.io/17AROg Fear not, you should be able to get what you need from " +
                "the shiny new Events API instead.\",\"documentation_url\":\"https://developer.github.com/v3/activity/events/#list-public-events\"}");
>>>>>>> 15bcdf07b90a16ea1f7151886a96cbbaa4817d59
    }
}