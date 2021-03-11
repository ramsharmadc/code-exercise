package dsa.problemsolving.oilpriceservice.jpa.repository;

import dsa.problemsolving.oilpriceservice.model.OilTypeRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OilTypeDataRepository extends InMemoryJPARepository<OilTypeRecord> {

    private static final OilTypeDataRepository instance = new OilTypeDataRepository();
    private final Map<String, OilTypeRecord> oilTypesData = new ConcurrentHashMap<>();

    private OilTypeDataRepository() {

    }

    public static OilTypeDataRepository getInstance() {
        return instance;
    }

    @Override
    public void init() {

        super.init();

        OilTypeRecord oilTypeRecord1 = new OilTypeRecord("AAC", "Standard", 1, 0, 42, true);
        OilTypeRecord oilTypeRecord2 = new OilTypeRecord("REW", "Standard", 7, 0, 47, true);
        OilTypeRecord oilTypeRecord3 = new OilTypeRecord("BWO", "Standard", 17, 0, 61, true);
        OilTypeRecord oilTypeRecord4 = new OilTypeRecord("TIM", "Premium", 5, 7, 111, true);
        OilTypeRecord oilTypeRecord5 = new OilTypeRecord("QFC", "Standard", 22, 0, 123, true);

        insert(oilTypeRecord1);
        insert(oilTypeRecord2);
        insert(oilTypeRecord3);
        insert(oilTypeRecord4);
        insert(oilTypeRecord5);
    }

    @Override
    public boolean insert(OilTypeRecord record) {
        oilTypesData.put(record.getOilId(), record);
        return true;
    }

    @Override
    public boolean delete(OilTypeRecord record) {
        oilTypesData.remove(record.getOilId());
        return true;
    }

    @Override
    public boolean update(OilTypeRecord record) {
        oilTypesData.remove(record.getOilId());
        oilTypesData.put(record.getOilId(), record);
        return true;
    }

    @Override
    public OilTypeRecord fetch(Object id) {
        return oilTypesData.get(id);
    }

    @Override
    public Map<Object, OilTypeRecord> fetchAll() {
        Map<Object, OilTypeRecord> result = new HashMap<>();
        oilTypesData.entrySet().stream().forEach(x -> result.put(x.getKey(), x.getValue()));
        return result;
    }
}
