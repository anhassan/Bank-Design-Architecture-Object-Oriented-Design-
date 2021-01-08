package Customer;

import Account.Account;

import java.util.ArrayList;
import java.util.List;


public abstract class Customer {
    public static long Id = 2000000L;
    private long customerId;
    private String name;
    private String address;
    private long taxId;
    private List<Account> accounts;

    public Customer(String name, String address, long taxId) {
        this.customerId = Customer.Id;
        this.name = name;
        this.address = address;
        this.taxId = taxId;
        Customer.Id += 7L;
        accounts = new ArrayList<Account>();
    }


    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(this.accounts.indexOf(account));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer customer = (Customer) obj;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) customerId;
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                '}';
    }
}
