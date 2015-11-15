package HelperObject;

import java.util.ArrayList;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Business {
    String businessName;
    ArrayList<CountTime> donations;

    public String getBusinessName() {
        return businessName;
    }

    public ArrayList<CountTime> getDonations() {
        return donations;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setDonations(ArrayList<CountTime> donations) {
        this.donations = donations;
    }
}
