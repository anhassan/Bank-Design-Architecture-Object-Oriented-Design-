import Account.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AccountTest {
    @Test
    public void testAccount() {

        Account account = new SavingsAccount();
        Account anotherAccount = new CheckingAccount();
        Account andAnotherAccount = new SavingsAccount();

        // checking auto-incrementing account ids
        assertEquals(1000L, account.getAccountId());
        assertEquals(1005L, anotherAccount.getAccountId());
        assertEquals(1010L, andAnotherAccount.getAccountId());

        // checking initial amount
        assertEquals(account.getBalance(), BigDecimal.valueOf(0));

        // checking the working of deposit
        account.deposit(BigDecimal.valueOf(1000));
        account.deposit(BigDecimal.valueOf(267));
        assertEquals(BigDecimal.valueOf(1267), account.getBalance());

        // checking the working of withdraw
        account.withdraw(BigDecimal.valueOf(17));
        assertEquals(BigDecimal.valueOf(1250), account.getBalance());

    }
}
