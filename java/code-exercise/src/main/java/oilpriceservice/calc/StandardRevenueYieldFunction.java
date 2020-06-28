package oilpriceservice.calc;

public class StandardRevenueYieldFunction implements RevenueYieldFunction {

	private double price;
	private double fixedRevenue;

	public StandardRevenueYieldFunction(double fixedRevenue, double price) {
		this.fixedRevenue = fixedRevenue;
		this.price = price;
	}

	@Override
	public double getRevenueYield() {
		return price != 0 ? fixedRevenue / price : 0;
	}
}
