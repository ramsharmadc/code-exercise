package practice.bankingapp;

public class DepositBankTransaction implements BankTransaction {

    private double amount;

    public DepositBankTransaction(double txnAmt) {
        this.amount = txnAmt;
    }

    @Override
    public void apply(BankAccount account) throws Exception {
        account.deposit(this.amount);
    }

    @Override
    public double txnAmount() {
        return amount;
    }

    @Override
    public String getReadableTxn() {
        return "DepositTxn";
    }
}
