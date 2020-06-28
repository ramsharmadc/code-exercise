package oilpriceservice.calc;

public class CalcFunctionFactory {

	public static CalcFunction getGeometricMeanFunction(double[] prices) {
		return new GeometricMeanFunction(prices);
	}

	public static CalcFunction getPremiumRevenueYieldFunction(double price, double variableRevenue,
			double oilBarrelValue) {
		return new PremiumRevenueYieldFunction(price, variableRevenue, oilBarrelValue);
	}

	public static CalcFunction getStandardRevenueYieldFunction(double price, double fixedRevenue) {
		return new StandardRevenueYieldFunction(fixedRevenue, price);
	}

	public static CalcFunction getVolumeWeightedPriceFunction(double[] prices, double[] quantities) {
		return new VolumeWeightedPriceFunction(prices, quantities);
	}

	public static CalcFunction getPriceEarningsRatioFunction(double price, double revenue) {
		return new PriceEarningsRatioFunction(price, revenue);
	}
}
