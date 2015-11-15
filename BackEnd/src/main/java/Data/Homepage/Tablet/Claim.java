package Data.Homepage.Tablet;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Claim {
    String business_id;

    public String getBusiness_id() {
        return business_id;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "business_id='" + business_id + '\'' +
                '}';
    }
}
