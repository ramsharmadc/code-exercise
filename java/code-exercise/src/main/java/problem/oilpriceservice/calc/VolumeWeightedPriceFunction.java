package problem.oilpriceservice.calc;

public class VolumeWeightedPriceFunction implements WeightedPriceFunction {

	double[] prices;
	double[] quantities;

	public VolumeWeightedPriceFunction(double[] prices, double[] quantities) {
		this.prices = prices;
		this.quantities = quantities;
	}

	@Override
	public double getWeightedPrice() {
		double wpu = 0.0;
		double dm = 0.0;

		for (int i = 0; i < prices.length; i++) {
			wpu += prices[i] * quantities[i];
		}

		for (int i = 0; i < quantities.length; i++) {
			dm += quantities[i];
		}

		return wpu / dm;
	}
}
