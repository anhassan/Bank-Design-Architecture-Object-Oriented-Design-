package Customer;

import Account.Account;
import Customer.Customer;

import java.math.BigDecimal;

public class Person extends Customer {

    public Person(String name, String address, long taxId) {
        super(name, address, taxId);
    }

    public void setAllAccountsToZero() {
        for (Account account : this.getAccounts()) {
            account.setBalance(BigDecimal.valueOf(0));
        }
    }
}
