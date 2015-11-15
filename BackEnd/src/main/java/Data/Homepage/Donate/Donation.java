package Data.Homepage.Donate;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Donation {
    String name;
    String donor_id;

    public String getName() {
        return name;
    }

    public String getDonor_id() {
        return donor_id;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "name='" + name + '\'' +
                ", donor_id='" + donor_id + '\'' +
                '}';
    }
}
