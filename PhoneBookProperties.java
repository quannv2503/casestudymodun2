package casestudymodun2;

import java.io.Serializable;

public class PhoneBookProperties implements Comparable<PhoneBookProperties>, Serializable {
    private String name;
    private String phone;

    public PhoneBookProperties() {
    }

    public PhoneBookProperties(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int compareTo(PhoneBookProperties o) {
        String a;
        String b;
        a = getName().substring(getName().lastIndexOf(" "));
        b = o.getName().substring(o.getName().lastIndexOf(" "));
        return a.compareTo(b);
    }
}
