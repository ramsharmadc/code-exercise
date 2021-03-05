package problemsolving.oilpriceservice.calc;

public class PremiumRevenueYieldFunction implements RevenueYieldFunction {

    private final double price;
    private final double variableRevenue;
    private final double oilBarrelValue;

    public PremiumRevenueYieldFunction(double price, double variableRevenue,
                                       double oilBarrelValue) {
        this.price = price;
        this.variableRevenue = variableRevenue;
        this.oilBarrelValue = oilBarrelValue;
    }

    @Override
    public double getRevenueYield() {
        return price != 0 ? (variableRevenue * oilBarrelValue) / price : 0;
    }
}
