package practice.javalang8.bankingapp;

public class WithdrawBankTransaction implements BankTransaction {

    private double amount;

    public WithdrawBankTransaction(double amt) {
        this.amount = amt;
    }

    @Override
    public void apply(BankAccount account) throws Exception {
        account.withdraw(this.amount);
    }

    @Override
    public double txnAmount() {
        return amount;
    }

    @Override
    public String getReadableTxn() {
        return "WithdrawTxn";
    }
}
