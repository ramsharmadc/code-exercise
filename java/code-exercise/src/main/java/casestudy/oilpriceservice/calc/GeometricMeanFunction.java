package casestudy.oilpriceservice.calc;

public class GeometricMeanFunction implements MeanFunction {

    double[] prices;

    public GeometricMeanFunction(double[] prices) {
        this.prices = prices;
    }

    @Override
    public double getMean() {
        if (prices.length == 0)
            return 0.0;
        double gm = 1.0;
        for (int i = 0; i < prices.length; i++) {
            gm *= prices[i];
        }
        gm = Math.pow(gm, 1.0 / (double) prices.length);
        return gm;
    }
}
