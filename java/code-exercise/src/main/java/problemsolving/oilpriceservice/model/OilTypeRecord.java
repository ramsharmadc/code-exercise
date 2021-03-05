package problemsolving.oilpriceservice.model;

import java.util.Objects;

public class OilTypeRecord {

    private String oilId;
    private String oilType;
    private double fixedRevenue;
    private double variableRevenue;
    private double oilBarrelValue;
    private boolean isActiveRecord;

    public OilTypeRecord(String oilId, String oilType, double fixedRevenue, double variableRevenue,
                         double oilBarrelValue, boolean isActiveRecord) {
        this.oilId = oilId;
        this.oilType = oilType;
        this.fixedRevenue = fixedRevenue;
        this.variableRevenue = variableRevenue;
        this.oilBarrelValue = oilBarrelValue;
        this.isActiveRecord = isActiveRecord;
    }

    public String getOilId() {
        return oilId;
    }

    public void setOilId(String oilId) {
        this.oilId = oilId;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public double getFixedRevenue() {
        return fixedRevenue;
    }

    public void setFixedRevenue(double fixedRevenue) {
        this.fixedRevenue = fixedRevenue;
    }

    public double getVariableRevenue() {
        return variableRevenue;
    }

    public void setVariableRevenue(double variableRevenue) {
        this.variableRevenue = variableRevenue;
    }

    public double getOilBarrelValue() {
        return oilBarrelValue;
    }

    public void setOilBarrelValue(double oilBarrelValue) {
        this.oilBarrelValue = oilBarrelValue;
    }

    public boolean isActiveRecord() {
        return isActiveRecord;
    }

    public void setActiveRecord(boolean activeRecord) {
        isActiveRecord = activeRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OilTypeRecord))
            return false;
        OilTypeRecord oilTypeRecord = (OilTypeRecord) o;
        return Double.compare(oilTypeRecord.getFixedRevenue(), getFixedRevenue()) == 0
                && Double.compare(oilTypeRecord.getVariableRevenue(), getVariableRevenue()) == 0
                && Double.compare(oilTypeRecord.getOilBarrelValue(), getOilBarrelValue()) == 0
                && isActiveRecord() == oilTypeRecord.isActiveRecord()
                && Objects.equals(getOilId(), oilTypeRecord.getOilId())
                && Objects.equals(getOilType(), oilTypeRecord.getOilType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOilId(), getOilType(), getFixedRevenue(), getVariableRevenue(),
                getOilBarrelValue(), isActiveRecord());
    }

    @Override
    public String toString() {
        return "OilTypeRecord{" + "oilId='" + oilId + '\'' + ", oilType='" + oilType + '\''
                + ", fixedRevenue=" + fixedRevenue + ", variableRevenue=" + variableRevenue
                + ", oilBarrelValue=" + oilBarrelValue + ", isActiveRecord=" + isActiveRecord + '}';
    }
}
