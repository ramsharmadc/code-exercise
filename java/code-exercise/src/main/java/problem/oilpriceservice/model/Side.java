package problem.oilpriceservice.model;

public enum Side {
	SELL("sell"), BUY("buy"), NONE("None");

	private String side;

	Side(String side) {
		this.side = side;
	}

	public String get() {
		return this.side;
	}
}
