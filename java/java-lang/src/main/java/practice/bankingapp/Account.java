package practice.jpmctest;

import java.util.List;

public interface Account {

    double getBalance();

    boolean apply(BankTransaction bankTransaction);

    List<BankTransaction> getAppliedTransactions();

    //void withdraw(double amount) throws Exception;

    //void deposit(double amt) throws Exception;
}
