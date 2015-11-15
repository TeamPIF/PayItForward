package Data.Homepage.Donate;

/**
 * Created by EvanKing on 11/15/15.
 */
public class Donation {
    String email;
    String donor_id;

    public String getEmail() {
        return email;
    }

    public String getDonor_id() {
        return donor_id;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "email='" + email + '\'' +
                ", donor_id='" + donor_id + '\'' +
                '}';
    }
}
