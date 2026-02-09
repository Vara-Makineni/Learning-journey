public class BankApplication {

    public static void main(String[] args) {


        Customer customer = new Customer("C101", "Sai");

        
        Account savings = new SavingsAccount("SA1001", 5000);
        Account checking = new CheckingAccount("CA2001", 3000);


        customer.addAccount(savings);
        customer.addAccount(checking);

        
        Transaction transaction = new TransactionImpl();

        // 5. Perform operations
        transaction.deposit(savings, 2000);
        transaction.withdraw(checking, 1000);
        transaction.transfer(savings, checking, 1500);

        // 6. Display final balances
        System.out.println("Final Balances:");
        for (Account acc : customer.getAccounts()) {
            System.out.println(
                acc.getAccountType() + " Account (" + acc.getAccountNumber() + ") : " + acc.getBalance()
            );
        }
    }
}
