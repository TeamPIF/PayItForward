package sectors;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Donation {
    int bid;
    Timestamp claim_time;
    String name;

    public Donation(int bid, Timestamp claim_time, String name) {
        this.bid = bid;
        this.claim_time = claim_time;
        this.name = name;
    }

    public void setBid(int bid) {

        this.bid = bid;
    }

    public void setClaim_time(Timestamp claim_time) {
        this.claim_time = claim_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid() {

        return bid;
    }

    public Timestamp getClaim_time() {
        return claim_time;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Donate{" +
                "bid=" + bid +
                ", claim_time=" + claim_time +
                ", name='" + name + '\'' +
                '}';
    }
}
