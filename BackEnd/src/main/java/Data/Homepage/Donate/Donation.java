package Data.Homepage.Donate;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Donation {
    String business_id;
    String donor_id;

    public String getBusiness_id() {
        return business_id;
    }

    public String getDonor_id() {
        return donor_id;
    }

    @Override
    public String toString() {
        return "Donate{" +
                "business_id='" + business_id + '\'' +
                ", donor_id='" + donor_id + '\'' +
                '}';
    }
}
