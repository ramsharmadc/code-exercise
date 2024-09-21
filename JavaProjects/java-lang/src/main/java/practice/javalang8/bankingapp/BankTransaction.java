package practice.javalang8.bankingapp;

public interface BankTransaction {

    void apply(BankAccount account) throws Exception;

    double txnAmount();

    String getReadableTxn();
}
