package sectors;

/**
 * Created by EvanKing on 11/14/15.
 */
public class Donor {
    String last_name;
    String first_name;
    String address;

    public Donor(String last_name, String first_name, String address) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.address = address;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getAddress() {
        return address;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
