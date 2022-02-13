package practice.jpmctest;

import java.util.function.BiConsumer;

public class TransactionExecutor implements BiConsumer<BankTransaction, BankAccount> {

    @Override
    public void accept(BankTransaction txn, BankAccount account) {
        account.apply(txn);
    }
}
