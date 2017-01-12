package sy.util.base;

import java.io.Serializable;

public class NameValuePair implements Comparable,Serializable {
    private String name;
    private String value;


    public NameValuePair() {
    }

    public NameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Object another) {

        NameValuePair other = (NameValuePair) another;
        return this.getName().compareTo(other.getName());
    }

}
