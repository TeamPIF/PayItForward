package Data.Homepage.Stories;

/**
 * Created by EvanKing on 11/15/15.
 */
public class ThankYou {
    String name;
    String message;

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ThankYou{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
