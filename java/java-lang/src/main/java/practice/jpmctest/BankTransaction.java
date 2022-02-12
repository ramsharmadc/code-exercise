package practice.jpmctest;

public interface BankTransaction {

    void apply(BankAccount account) throws Exception;

    double txnAmount();

    String getReadableTxn();
}
