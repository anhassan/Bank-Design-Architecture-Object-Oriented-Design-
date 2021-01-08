package Account;

import java.math.BigDecimal;


public abstract class Account {
    public static long Id = 1000L;
    private long accountId;
    private BigDecimal balance;

    public Account() {
        this.accountId = Account.Id;
        this.balance = BigDecimal.valueOf(0);
        Account.Id += 5;
    }

    public long getAccountId() {
        return accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal withdraw(BigDecimal amount) {
        setBalance(getBalance().subtract(amount));
        return getBalance();

    }

    public BigDecimal deposit(BigDecimal amount) {
        setBalance(getBalance().add(amount));
        return getBalance();
    }

    public BigDecimal correctBalance(BigDecimal amount) {
        setBalance(amount);
        return getBalance();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return accountId == account.accountId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) accountId;
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", balance=" + balance +
                '}';
    }
}
