package lang.jpmc.test;

import java.util.function.BiConsumer;

public class TransactionExecutor implements BiConsumer<BankTransaction, BankAccount> {

    @Override
    public void accept(BankTransaction txn, BankAccount account) {
        account.apply(txn);
    }
}
