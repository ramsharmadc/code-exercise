package casestudy.oilpriceservice.calc;

public class StandardRevenueYieldFunction implements RevenueYieldFunction {

    private final double price;
    private final double fixedRevenue;

    public StandardRevenueYieldFunction(double fixedRevenue, double price) {
        this.fixedRevenue = fixedRevenue;
        this.price = price;
    }

    @Override
    public double getRevenueYield() {
        return price != 0 ? fixedRevenue / price : 0;
    }
}
