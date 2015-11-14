/**
 * Created by EvanKing on 11/14/15.
 */
import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World Confirm");
    }
}