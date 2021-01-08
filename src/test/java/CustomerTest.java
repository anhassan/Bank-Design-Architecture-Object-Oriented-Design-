import Account.*;
import Customer.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void testCustomer() {
        Customer person1 = new Person("Tom", "Toronto", 123L);
        Customer person2 = new Person("Bob", "Vancouver", 456L);

        Account account1 = new CheckingAccount();
        Account account2 = new SavingsAccount();

        // checking auto-incrementing account ids
        assertEquals(2000000L, person1.getCustomerId());
        assertEquals(2000007, person2.getCustomerId());

        // checking addition of accounts in customer
        person1.addAccount(account1);
        person1.addAccount(account2);

        assertEquals(2, person1.getAccounts().size());
        assertEquals(1000L, person1.getAccounts().get(0).getAccountId());
        assertEquals(1005L, person1.getAccounts().get(1).getAccountId());

        // checking deletion of accounts in customer
        person1.removeAccount(account1);
        assertEquals(1, person1.getAccounts().size());
        assertEquals(1005L, person1.getAccounts().get(0).getAccountId());

    }

    @Test
    public void testPerson() {
        Person person = new Person("Mike", "Waterloo", 123L);
        Account account1 = new SavingsAccount();
        Account account2 = new CheckingAccount();

        account1.deposit(BigDecimal.valueOf(1255));
        account2.deposit(BigDecimal.valueOf(2150));
        person.addAccount(account1);
        person.addAccount(account2);

        // check whether the balance of all the accounts is turned to zero or not
        person.setAllAccountsToZero();
        assertEquals(2, person.getAccounts().size());
        assertEquals(BigDecimal.valueOf(0), person.getAccounts().get(0).getBalance());
        assertEquals(BigDecimal.valueOf(0), person.getAccounts().get(1).getBalance());
    }

    @Test
    public void testCompany() {
        Company company = new Company("Walmart", "Toronto", 123L);
        Account account1 = new SavingsAccount();
        Account account2 = new CheckingAccount();

        account1.deposit(BigDecimal.valueOf(1400));
        account2.deposit(BigDecimal.valueOf(1460));
        company.addAccount(account1);
        company.addAccount(account2);

        // check whether the amount is added to all accounts
        company.addToAllAccounts(BigDecimal.valueOf(2000));
        assertEquals(BigDecimal.valueOf(3400), company.getAccounts().get(0).getBalance());
        assertEquals(BigDecimal.valueOf(3460), company.getAccounts().get(1).getBalance());
    }
}
