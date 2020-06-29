package problem.oilpriceservice.calc;

public class PremiumRevenueYieldFunction implements RevenueYieldFunction {

	private double price;
	private double variableRevenue;
	private double oilBarrelValue;

	public PremiumRevenueYieldFunction(double price, double variableRevenue, double oilBarrelValue) {
		this.price = price;
		this.variableRevenue = variableRevenue;
		this.oilBarrelValue = oilBarrelValue;
	}

	@Override
	public double getRevenueYield() {
		return price != 0 ? (variableRevenue * oilBarrelValue) / price : 0;
	}
}
