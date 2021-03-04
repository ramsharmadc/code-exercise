package casestudy.oilpriceservice.model;

public enum OilType {

    PREMIUM("Premium"), STANDARD("Standard");

    private final String type;

    OilType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
