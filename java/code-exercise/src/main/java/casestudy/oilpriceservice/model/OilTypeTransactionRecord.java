package casestudy.oilpriceservice.model;

import java.sql.Timestamp;
import java.util.Objects;

public class OilTypeTransactionRecord {

    private OilTypeRecord oilTypeRecord;
    private Timestamp createdTimestamp;
    private double quantity;
    private Side side;
    private double price;
    private boolean isActiveRecord;

    public OilTypeTransactionRecord(OilTypeRecord oilTypeRecord, Timestamp createdTimestamp,
                                    double quantity, Side side, double price, boolean isActiveRecord) {
        this.oilTypeRecord = oilTypeRecord;
        this.createdTimestamp = createdTimestamp;
        this.quantity = quantity;
        this.side = side;
        this.price = price;
        this.isActiveRecord = isActiveRecord;
    }

    public OilTypeRecord getOilTypeRecord() {
        return oilTypeRecord;
    }

    public void setOilTypeRecord(OilTypeRecord oilTypeRecord) {
        this.oilTypeRecord = oilTypeRecord;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public boolean isActiveRecord() {
        return isActiveRecord;
    }

    public void setActiveRecord(boolean activeRecord) {
        isActiveRecord = activeRecord;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OilTypeTransactionRecord))
            return false;
        OilTypeTransactionRecord that = (OilTypeTransactionRecord) o;
        return Double.compare(that.getQuantity(), getQuantity()) == 0
                && isActiveRecord() == that.isActiveRecord()
                && getOilTypeRecord() == that.getOilTypeRecord()
                && Double.compare(getPrice(), that.getPrice()) == 0
                && Objects.equals(getCreatedTimestamp(), that.getCreatedTimestamp())
                && getSide() == that.getSide();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOilTypeRecord(), getCreatedTimestamp(), getPrice(), getQuantity(),
                getSide(), isActiveRecord());
    }

    @Override
    public String toString() {
        return "OilTypeTransactionRecord{" + "oilTypeRecord=" + oilTypeRecord
                + ", createdTimestamp=" + createdTimestamp + ", quantity=" + quantity + ", price="
                + price + ", side=" + side + ", isActiveRecord=" + isActiveRecord + '}';
    }
}
