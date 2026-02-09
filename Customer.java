import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String customerId;
    private String name;
    private List<Account> accounts = new ArrayList<>();

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        accounts.add(account);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

   

}