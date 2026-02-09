public class TransactionImpl implements Transaction {

    @Override
    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    @Override
    public void transfer(Account from, Account to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }
}
