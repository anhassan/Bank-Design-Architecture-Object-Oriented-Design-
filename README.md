# Introduction
This application will be used to generate and organize data for a bank. We want to create, manipulate, and track different types of bank accounts, different types of customers, and the connections between accounts and users. There will be no persistence or storage (data will have to be recreated each time the program is executed). Proper testing is done through unit tests of each of the components of the main design.

# Design Specifications
Bank Accounts have the following specifications:

-   Bank Accounts have Account Identification Numbers and Balances.
    
-   The ID Number is set when the Bank Account is first created and never modified.
  
-   ID number (System generated) must be unique across all accounts regardless of type or owner. (Starts at 1000 and counts by 5)

-   The Balance can be increased with a Deposit, decreased with a Withdraw, or completely changed with a Correction.
    
***Bank Account categories:***

-   Savings Accounts vs. Current Accounts
    
-   Business Accounts vs. Personal Accounts
    

Accounts can fall into different combinations:

-   Business Savings
    
-   Business Current
    
-   Personal Savings
    
-   Personal Current
    

***Current Accounts:***

-   Allowed to be overdrawn
    
-   Track the number of the next cheque to be issued (can be updated by requesting next cheque)
    
-   First check number to be issued is set on creation
    

***Savings Accounts:***

-   Can never be overdrawn
    
-   Stores an interest rate (do not calculate interest – just store the value)
    
-   Interest Rate can be accessed and changed. Initialized to 0%.
    

***Business Accounts:***

-   Must belong to a company
    

***Personal Accounts:***

-   Must belong to a person
    

***Bank Customers:***

-   Bank Customers have ID numbers, Names, addresses, Tax Id Numbers (not internally generated)
    
-   ID numbers are unique and auto-generated, starting at 2000000 and counting by 7s
    

Customers come in two flavours:

-   Company vs. Person
    

***Company***

-   Can add the same amount (specified by user) to all of the accounts it owns at once
    

***Person***

-   Can reset all of his/her accounts' balances back to 0 in one step
    

***Managing data:***

-   Any number of accounts and/or customers may exist in the system at once
    
-   Each account must belong to at least one customer
    
-   A customer can own any number of accounts
    
-   Accounts and customers are never to be duplicated -- each new object should represent a completely new item
    
-   If a company or person is removed from the system, the attached accounts must be removed as well 

The entire design can be viewed pictorially through the UML design below for more clarity
<p align="center">
  <img src="/assets/BankDesignUML.png" />
</p>
