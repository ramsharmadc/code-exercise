package problem.oilpriceservice.jpa.repository;

import problem.oilpriceservice.model.OilTypeTransactionRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OilTypeTransactionDataRepository extends InMemoryJPARepository<OilTypeTransactionRecord> {

	private static final OilTypeTransactionDataRepository instance = new OilTypeTransactionDataRepository();
	private final Map<String, OilTypeTransactionRecord> oilTypesTransactionsData = new ConcurrentHashMap<>();

	private OilTypeTransactionDataRepository() {
	}

	public static OilTypeTransactionDataRepository getInstance() {
		return instance;
	}

	@Override
	public boolean insert(OilTypeTransactionRecord record) {
		oilTypesTransactionsData.put(record.getOilTypeRecord().getOilId(), record);
		return true;
	}

	@Override
	public boolean delete(OilTypeTransactionRecord record) {
		oilTypesTransactionsData.remove(record.getOilTypeRecord().getOilId());
		return true;
	}

	@Override
	public boolean update(OilTypeTransactionRecord record) {
		oilTypesTransactionsData.remove(record.getOilTypeRecord().getOilId());
		oilTypesTransactionsData.put(record.getOilTypeRecord().getOilId(), record);
		return true;
	}

	@Override
	public OilTypeTransactionRecord fetch(Object id) {
		return oilTypesTransactionsData.get(id);
	}

	@Override
	public Map<Object, OilTypeTransactionRecord> fetchAll() {
		Map<Object, OilTypeTransactionRecord> result = new HashMap<>();
		oilTypesTransactionsData.entrySet().stream().forEach(x -> result.put(x.getKey(), x.getValue()));
		return result;
	}
}
