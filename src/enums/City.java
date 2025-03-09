package enums;

public enum City {
    BANGALORE("BANGALORE"),
    DELHI("DELHI"),
    MUMBAI("MUMBAI");

    City(String city) {
        this.value = city;
    }
    private final String value;

    public String getValue() {
        return this.value;
    }
}
