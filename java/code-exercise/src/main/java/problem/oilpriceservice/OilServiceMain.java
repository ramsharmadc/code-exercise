package problem.oilpriceservice;

import problem.oilpriceservice.jpa.repository.JPARepository;
import problem.oilpriceservice.jpa.repository.OilTypeDataRepository;
import problem.oilpriceservice.jpa.repository.OilTypeTransactionDataRepository;
import problem.oilpriceservice.model.OilTypeRecord;
import problem.oilpriceservice.model.OilTypeTransactionRecord;
import problem.oilpriceservice.model.Side;
import problem.oilpriceservice.service.OilBusinessService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

public class OilServiceMain {

	public static void main(String[] args) {

		// Initialize the Data repository for Oil Data
		JPARepository<OilTypeRecord> dataJPARepository = OilTypeDataRepository.getInstance();
		((OilTypeDataRepository) dataJPARepository).init();

		// Initialize the Data repository for Oil Data Transaction
		JPARepository<OilTypeTransactionRecord> txnJPARepository = OilTypeTransactionDataRepository.getInstance();

		// Initialize the Oil Business Service
		OilBusinessService oilBusinessService = new OilBusinessService(dataJPARepository, txnJPARepository);

		// Get Revenue Yields
		Map<String, Double> revenueYields = oilBusinessService.getRevenueYield(43);

		// Get Price earning ratios
		Map<String, Double> priceEarningsRatios = oilBusinessService.getPriceEarningsRatio(43);

		// Recording Transactions
		OilTypeRecord oilTypeRecordAAC = dataJPARepository.fetch("AAC");
		OilTypeRecord oilTypeRecordREW = dataJPARepository.fetch("REW");
		OilTypeRecord oilTypeRecordBWO = dataJPARepository.fetch("BWO");
		OilTypeRecord oilTypeRecordTIM = dataJPARepository.fetch("TIM");
		OilTypeRecord oilTypeRecordQFC = dataJPARepository.fetch("QFC");
		oilBusinessService.recordTransaction(oilTypeRecordAAC, Timestamp.from(Calendar.getInstance().toInstant()), 200,
				Side.SELL, 34.2, true);
		oilBusinessService.recordTransaction(oilTypeRecordREW, Timestamp.from(Calendar.getInstance().toInstant()), 300,
				Side.SELL, 34.3, true);
		oilBusinessService.recordTransaction(oilTypeRecordBWO, Timestamp.from(Calendar.getInstance().toInstant()), 400,
				Side.BUY, 34.4, true);
		oilBusinessService.recordTransaction(oilTypeRecordTIM, Timestamp.from(Calendar.getInstance().toInstant()), 500,
				Side.SELL, 34.5, true);
		oilBusinessService.recordTransaction(oilTypeRecordQFC, Timestamp.from(Calendar.getInstance().toInstant()), 600,
				Side.BUY, 34.6, true);

		// Finding Volume Weighted Transactions
		Map<String, Double> volumeWeightedTransactions = oilBusinessService.getVolumeWeightedOilPrice(30);

		// Finding Geometric Mean
		Map<String, Double> geometricMean = oilBusinessService.getGeometricMean();

		// Print results
		System.out.println("Revenue Yields => " + revenueYields);
		System.out.println("Price earnings => " + priceEarningsRatios);
		txnJPARepository.fetchAll().entrySet().stream().forEach(x -> System.out.println(x));
		System.out.println(volumeWeightedTransactions);
		System.out.println(geometricMean);
	}
}
