public class SavingsAccount extends Account {

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public String getAccountType() {
        return "Savings";
    }
}
