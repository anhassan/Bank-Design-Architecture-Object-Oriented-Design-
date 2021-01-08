package Account;

public class CheckingAccount extends Account {
    private int checkId = 0;

    public CheckingAccount() {
        super();
    }

    public int getNextCheckNumber() {
        checkId++;
        return checkId;
    }

}
