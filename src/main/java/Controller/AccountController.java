package Controller;


import Account.*;
import Customer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountController {
    private Map<Long, Customer> customerByIdNumber;
    private Map<Long, Account> accountsByIdNumber;

    public AccountController() {
        customerByIdNumber = new HashMap<Long, Customer>();
        accountsByIdNumber = new HashMap<Long, Account>();
    }

    public Map<Long, Customer> getCustomerByIdNumber() {
        return this.customerByIdNumber;
    }

    public void setCustomerByIdNumber(Map<Long, Customer> customerByIdNumber) {
        this.customerByIdNumber = this.customerByIdNumber;
    }

    public Map<Long, Account> getAccountsByIdNumber() {
        return accountsByIdNumber;
    }

    public void setAccountsByIdNumber(Map<Long, Account> accountsByIdNumber) {
        this.accountsByIdNumber = accountsByIdNumber;
    }

    public Customer createCustomer(String name, String address, long taxid, CustomerType type) {
        Customer customer = null;
        if (type == CustomerType.PERSON) {
            customer = new Person(name, address, taxid);

        } else if (type == CustomerType.COMPANY) {
            customer = new Company(name, address, taxid);
        }
        this.customerByIdNumber.put(customer.getCustomerId(), customer);
        return customer;
    }

    public Account createAccount(AccountType type, Customer owner) {
        Account account = null;
        if (type == AccountType.CHECKING) {
            account = new CheckingAccount();
        } else if (type == AccountType.SAVINGS) {
            account = new SavingsAccount();
        }
        owner.addAccount(account);
        this.accountsByIdNumber.put(account.getAccountId(), account);
        return account;
    }

    public void removeAccount(Account account) {
        // removing account from the account map

        if (this.accountsByIdNumber.containsValue(account)) {
            this.accountsByIdNumber.remove(account.getAccountId());
        }
        // removing account from the customer
        for (Customer customer : this.customerByIdNumber.values()) {
            if (customer.getAccounts().contains(account)) {
                customer.removeAccount(account);
            }
        }
    }

    public void removeCustomer(Customer customer) {
        //removing customer from the customer map
        if (this.customerByIdNumber.containsValue(customer)) {
            this.customerByIdNumber.remove(customer.getCustomerId());
        }
        //removing all the accounts associated with the customer
        List<Account> toBeDeletedAccounts = new ArrayList<Account>(customer.getAccounts());
        for (Account account : toBeDeletedAccounts) {
            customer.removeAccount(account);
            this.accountsByIdNumber.remove(account.getAccountId());
        }
    }


}
