package problem.oilpriceservice.service;

import problem.oilpriceservice.calc.*;
import problem.oilpriceservice.jpa.repository.JPARepository;
import problem.oilpriceservice.model.OilType;
import problem.oilpriceservice.model.OilTypeRecord;
import problem.oilpriceservice.model.OilTypeTransactionRecord;
import problem.oilpriceservice.model.Side;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class OilBusinessService {

	private static final Logger LOGGER = Logger.getLogger(OilBusinessService.class.getName());

	private RevenueYieldFunction revenueYieldFunction;
	private RatioFunction priceEarningsRatioFunction;
	private MeanFunction geometricMeanFunction;
	private WeightedPriceFunction volumeWeightedPriceFunction;

	private JPARepository<OilTypeRecord> oilTypeRepository;
	private JPARepository<OilTypeTransactionRecord> oilTransactionRepository;

	public OilBusinessService(JPARepository<OilTypeRecord> oilTypeRepository,
			JPARepository<OilTypeTransactionRecord> oilTransactionRepository) {
		this.oilTypeRepository = oilTypeRepository;
		this.oilTransactionRepository = oilTransactionRepository;
	}

	/**
	 * Returns Revenue Yield
	 *
	 * @param price
	 * @return
	 */
	public Map<String, Double> getRevenueYield(double price) {
		LOGGER.info("Getting Revenue Yield for Price -> " + price);
		final Map<String, Double> result = new HashMap<>();
		oilTypeRepository.fetchAll().entrySet().stream().forEach(x -> {
			result.put((String) x.getKey(), getRevenueYield(price, x.getValue()));
		});
		return result;
	}

	/**
	 * Returns Price Earnings Ratio
	 *
	 * @param price
	 * @return
	 */
	public Map<String, Double> getPriceEarningsRatio(double price) {
		LOGGER.info("Getting Price Earnings Ratio for Price -> " + price);
		final Map<String, Double> result = new HashMap<>();
		oilTypeRepository.fetchAll().entrySet().stream().forEach(x -> {
			result.put((String) x.getKey(), getPriceEarningsRatio(price, x.getValue()));
		});
		return result;
	}

	/**
	 * Records Transactions
	 *
	 * @param oilData
	 * @param createsTimestamp
	 * @param quantity
	 * @param side
	 * @param price
	 * @param isActiveRecord
	 * @return
	 */
	public boolean recordTransaction(OilTypeRecord oilData, Timestamp createsTimestamp, double quantity, Side side,
			double price, boolean isActiveRecord) {

		OilTypeTransactionRecord oilTypeTransactionRecord = new OilTypeTransactionRecord(oilData, createsTimestamp,
				quantity, side, price, isActiveRecord);

		LOGGER.info("Recording transaction -> " + oilTypeTransactionRecord);

		oilTransactionRepository.insert(oilTypeTransactionRecord);
		return true;
	}

	/**
	 * retunns Volume weighted Oil Price
	 *
	 * @param lastNMinutes
	 * @return
	 */
	public Map<String, Double> getVolumeWeightedOilPrice(int lastNMinutes) {
		LOGGER.info("Get Volume Weighted Oil Price for last minutes -> " + lastNMinutes);
		final Map<String, Double> result = new HashMap<>();
		oilTransactionRepository.fetchAll().entrySet().stream().forEach(x -> {
			result.put((String) x.getKey(), getVolumeWeightedOilPrice(lastNMinutes, x.getValue()));
		});
		return result;
	}

	/**
	 * returns geometric mean
	 *
	 * @return
	 */
	public Map<String, Double> getGeometricMean() {
		LOGGER.info("Get Geometric Mean");

		final Map<String, Double> result = new HashMap<>();

		oilTransactionRepository.fetchAll().entrySet().stream().forEach(x -> {
			result.put((String) x.getKey(), getGeometricMean(x.getValue()));
		});

		return result;
	}

	private double getRevenueYield(double price, OilTypeRecord oilTypeRecord) {
		revenueYieldFunction = (RevenueYieldFunction) (oilTypeRecord.getOilType().equals(OilType.PREMIUM.getType())
				? CalcFunctionFactory.getPremiumRevenueYieldFunction(price, oilTypeRecord.getVariableRevenue(),
						oilTypeRecord.getOilBarrelValue())
				: CalcFunctionFactory.getStandardRevenueYieldFunction(price, oilTypeRecord.getFixedRevenue()));
		return revenueYieldFunction.getRevenueYield();
	}

	private double getPriceEarningsRatio(double price, OilTypeRecord oilTypeRecord) {
		priceEarningsRatioFunction = (RatioFunction) CalcFunctionFactory.getPriceEarningsRatioFunction(price,
				oilTypeRecord.getFixedRevenue());
		return priceEarningsRatioFunction.getRatio();
	}

	private double getVolumeWeightedOilPrice(int lastNMinutes, OilTypeTransactionRecord oilTypeRecord) {

		Map<Object, OilTypeTransactionRecord> result = oilTransactionRepository.fetchAll();
		Map<String, OilTypeTransactionRecord> last30MinutesTransactions = new HashMap<>();

		result.entrySet().stream().forEach(x -> {
			if (oilTypeRecord.getOilTypeRecord().getOilId().equals(x.getValue().getOilTypeRecord().getOilId())
					&& (Calendar.getInstance().toInstant().getNano()
							- x.getValue().getCreatedTimestamp().toInstant().getNano()) <= lastNMinutes * 60 * 60
									* 60) {
				last30MinutesTransactions.put((String) x.getKey(), x.getValue());
			}
		});

		double[] prices = new double[last30MinutesTransactions.size()];
		double[] quantities = new double[prices.length];
		int c = 0;

		for (Map.Entry<String, OilTypeTransactionRecord> e : last30MinutesTransactions.entrySet()) {
			prices[c] = e.getValue().getPrice();
			quantities[c] = e.getValue().getQuantity();
			c += 1;
		}

		volumeWeightedPriceFunction = (WeightedPriceFunction) CalcFunctionFactory.getVolumeWeightedPriceFunction(prices,
				quantities);

		return priceEarningsRatioFunction.getRatio();
	}

	private double getGeometricMean(OilTypeTransactionRecord oilTypeTxnRecord) {
		Set<Map.Entry<Object, OilTypeTransactionRecord>> entries = oilTransactionRepository.fetchAll().entrySet();
		double[] prices = new double[entries.size()];
		int c = 0;

		for (Map.Entry<Object, OilTypeTransactionRecord> e : entries) {
			if (e.getValue().getOilTypeRecord().getOilId().equals(oilTypeTxnRecord.getOilTypeRecord().getOilId())) {
				prices[c] = e.getValue().getPrice();
				c += 1;
			}
		}
		int d = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] != 0)
				d += 1;
		}

		double[] pricesNonZero = new double[d];
		for (int i = 0; i < d; i++) {
			if (prices[i] != 0)
				pricesNonZero[i] = prices[i];
		}

		geometricMeanFunction = (MeanFunction) CalcFunctionFactory.getGeometricMeanFunction(pricesNonZero);
		return geometricMeanFunction.getMean();
	}
}
