package oilpriceservice.model;

public enum OilType {

	PREMIUM("Premium"), STANDARD("Standard");

	private String type;

	OilType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
