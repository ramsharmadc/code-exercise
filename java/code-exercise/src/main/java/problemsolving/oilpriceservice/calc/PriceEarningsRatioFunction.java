package problemsolving.oilpriceservice.calc;

public class PriceEarningsRatioFunction implements RatioFunction {

    private final double price;
    private final double revenue;

    public PriceEarningsRatioFunction(double price, double revenue) {
        this.price = price;
        this.revenue = revenue;
    }

    @Override
    public double getRatio() {
        return revenue != 0 ? price / revenue : 0;
    }
}
