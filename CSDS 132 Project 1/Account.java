/* Chaehyeon Kim, class Account to record amount of money individual owes */

public class Account {
  
  // a field that keeps track of an account number
  private final String accountNumber;
  // a field that stores the current balance for the account
  private double currentBalance = 0.0;
  // a field to keep a balance limit of the account
  private int balanceLimit;
  
  /* a constructor that takes two inputs; the acct. # & balance limit*/
  public Account (String accountNumber, int balanceLimit) {
    this.accountNumber = accountNumber;
    this.balanceLimit = balanceLimit;
  }
  
  /* 1a) a method to get/access the account number*/
  public String getAccountNumber() {
    return accountNumber;
  }
  
  /* 1b) a method that returns the current balance of the account*/
  public double getBalance() {
    return currentBalance;
  }
  
  /* 1c) a method that increases the balance by the input amount*/
  public void charge(double value) { // value: represents amount that balance increase by
    currentBalance = currentBalance + value;
  }
  
  /* 1d) a method that decrease the balance by the input amount */
  public void credit(double value) { // value: represents amount that balance decrease by
    currentBalance = currentBalance - value; 
  }
   
  /* 1e) a method that changes the balance limit to be the input value */ 
  public void setBalanceLimit(int balanceLimit) {
    this.balanceLimit = balanceLimit;
  }
  
  /* 1f) a method that returns the balance limit of the account*/
  public int getBalanceLimit() {
    return balanceLimit;
  }
   
}