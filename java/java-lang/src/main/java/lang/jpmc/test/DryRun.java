package lang.jpmc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class DryRun {

    private BankAccount bankAccount;
    private TransactionExecutor transactionExecutor;

    @BeforeEach
    public void setup() {
        bankAccount = new BankAccount(3000);
        transactionExecutor = new TransactionExecutor();
    }

    @Test
    public void testWithdraw() {
        try {
            bankAccount.withdraw(1500);
            Assertions.assertEquals(1500, bankAccount.getBalance());
        } catch (Exception e) {
            Assertions.fail("operation failed");
        }

    }

    @Test
    public void testDeposit() {
        try {
            bankAccount.deposit(2000);
            Assertions.assertEquals(5000, bankAccount.getBalance());
        } catch (Exception e) {
            Assertions.fail("operation failed");
        }

    }

    @Test
    public void testInvalidAmountDeposit() {
        Assertions.assertThrows(Exception.class, () -> bankAccount.deposit(0));
        Assertions.assertThrows(Exception.class, () -> bankAccount.deposit(-400));
    }

    @Test
    public void testInvalidAmountWithdraw() {
        Assertions.assertThrows(Exception.class, () -> bankAccount.withdraw(8000));
        Assertions.assertThrows(Exception.class, () -> bankAccount.withdraw(-2000));
    }

    @Test
    public void testWithdrawTxn() {
        BankTransaction withdrawBankTransaction = new WithdrawBankTransaction(200);

        try {
//            withdrawBankTransaction.apply(bankAccount);
            transactionExecutor.accept(withdrawBankTransaction, bankAccount);
        } catch (Exception e) {
            Assertions.fail("Test failed " + e);
        }
        Assertions.assertEquals(2800, bankAccount.getBalance());
    }

    @Test
    public void testDepositTxn() {
        BankTransaction depositBankTransaction = new DepositBankTransaction(200);
        try {
//            depositBankTransaction.apply(bankAccount);
            transactionExecutor.accept(depositBankTransaction, bankAccount);
        } catch (Exception e) {
            Assertions.fail("Test failed " + e);
        }
        Assertions.assertEquals(3200, bankAccount.getBalance());
    }

    @Test
    public void testTransactions() {
        Assertions.assertEquals(0, bankAccount.getAppliedTransactions().size());

        List<BankTransaction> actualTxns = new LinkedList<>();

        BankTransaction withdrawBankTransaction = new WithdrawBankTransaction(200);
//        bankAccount.apply(withdrawBankTransaction);
        transactionExecutor.accept(withdrawBankTransaction, bankAccount);
        actualTxns.add(withdrawBankTransaction);

        BankTransaction depositBankTransaction = new DepositBankTransaction(200);
//        bankAccount.apply(depositBankTransaction);
        transactionExecutor.accept(depositBankTransaction, bankAccount);
        actualTxns.add(depositBankTransaction);

        Assertions.assertEquals(2, bankAccount.getAppliedTransactions().size());

        Assertions.assertIterableEquals(actualTxns, bankAccount.getAppliedTransactions());
    }
}