import Account.*;
import Controller.AccountController;
import Customer.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountControllerTest {
    AccountController accountController = new AccountController();


    @Test
    public void testAccountController() {
        Customer company = accountController.createCustomer
                ("CIBC", "Toronto", 123L, CustomerType.COMPANY);
        Customer person = accountController.createCustomer
                ("Bob", "Vancouver", 456L, CustomerType.PERSON);

        Account account1 = accountController.createAccount(AccountType.CHECKING, company);
        Account account2 = accountController.createAccount(AccountType.SAVINGS, company);
        Account account3 = accountController.createAccount(AccountType.CHECKING, company);
        Account account4 = accountController.createAccount(AccountType.SAVINGS, person);

        // checking the working of creation methods
        assertEquals(3, company.getAccounts().size());
        assertEquals(4, accountController.getAccountsByIdNumber().size());

        // checking account remove method
        accountController.removeAccount(account3);
        assertEquals(3, accountController.getAccountsByIdNumber().size());
        assertEquals(2, company.getAccounts().size());
        assertEquals(1000L, company.getAccounts().get(0).getAccountId());
        assertEquals(1005L, company.getAccounts().get(1).getAccountId());

        // checking removing customer method
        accountController.removeCustomer(company);
        assertEquals(1, accountController.getCustomerByIdNumber().size());
        assertEquals("Bob", accountController.getCustomerByIdNumber().get(person.getCustomerId()).getName());
        assertEquals(1, accountController.getAccountsByIdNumber().size());
        assertEquals(1015L, accountController.getAccountsByIdNumber().get(account4.getAccountId()).getAccountId());

    }

}
