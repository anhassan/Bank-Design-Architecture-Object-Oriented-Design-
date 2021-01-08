package Account;

import Account.Account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal interestRate;

    public SavingsAccount() {
        super();
    }


    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
