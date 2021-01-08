package Customer;

import Account.Account;
import Customer.Customer;

import java.math.BigDecimal;

public class Company extends Customer {
    public Company(String name, String address, long taxId) {
        super(name, address, taxId);
    }

    public void addToAllAccounts(BigDecimal amount) {
        for (Account account : this.getAccounts()) {
            account.setBalance(account.getBalance().add(amount));
        }
    }
}
