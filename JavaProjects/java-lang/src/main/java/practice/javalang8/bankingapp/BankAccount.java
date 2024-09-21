package practice.javalang8.bankingapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccount implements Account {

    private volatile double amount;
    private final List<BankTransaction> appliedBankTransactions;

    public BankAccount(double amount) {
        this.amount = amount;
        appliedBankTransactions = new LinkedList<>();
    }

    @Override
    public double getBalance() {
        return amount;
    }

    @Override
    public boolean apply(BankTransaction txn) {

        synchronized (this) {
            try {
                txn.apply(this);
                appliedBankTransactions.add(txn);
                return true;
            } catch (Exception e) {
                System.out.println("Transaction failed with error = " + e);
                return false;
            }
        }
    }

    @Override
    public List<BankTransaction> getAppliedTransactions() {
        return appliedBankTransactions;
    }

    public void withdraw(double amt) throws Exception {
        if (amountNonZero(amt) && enoughBalanceForWithdrawal(amt)) {
            synchronized (this) {
                this.amount = this.amount - amt;
            }
        }
    }

    public void deposit(double amt) throws Exception {
        if (amountNonZero(amt)) {
            synchronized (this) {
                this.amount += amt;
            }
        }
    }

    private boolean amountNonZero(double amt) throws Exception {
        if (amt <= 0) throw new Exception("Invalid Amount");
        else return true;
    }

    private boolean enoughBalanceForWithdrawal(double amt) throws Exception {
        if (amt > this.amount) throw new Exception("Invalid Amount");
        else return true;
    }
}
