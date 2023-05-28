/* Chaehyeon Kim, CreditAccount class to represent when customers borrow money*/

public class CreditAccount extends Account{
  
  // a field that stores the interest rate
  private double interestRate;
  // a field that stores the monthly payment amount
  private double monthlyPayment = 0.0;
  // a field that stores the amount credited
  private double amountPaidThisMonth = 0.0;
  
  /* a constructor for CreditAccount class */
  public CreditAccount (String accountNumber, double interestRate) {
    super(accountNumber, 0);
    this.interestRate = interestRate;
  }
  
  
  /* 1a) a method that sets the interest rate for account*/
  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
  
  /* 1b) a method that returns the interest rate for the account*/
  public double getInterestRate() {
    return interestRate;
  }
  
  /* 1c) a method that returns the montly payment amount; must be paid to avoid charge*/
  public double getMonthlyPayment() {
    return monthlyPayment;
  }
  
  /* 1d) a method that returns the amount credited to account*/
  public double getAmountPaidThisMonth() {
    return amountPaidThisMonth;
  }
  
  /* 1e) a method that checks for interest charge & resets account*/
  public void endOfMonth() {
    if (getAmountPaidThisMonth() < getMonthlyPayment()) 
      charge((getInterestRate() * getBalance()) / 12);
    monthlyPayment = getBalance();
    amountPaidThisMonth = 0;
  }
  
  @Override
  /* overriding credit method to decrease acct. balance & increase amt. paid */
  public void credit(double value) { // value: represents amt. acct. balance decrease & amt. paid increase
    charge(-value);
    amountPaidThisMonth = amountPaidThisMonth + value;
  } 
  
  
}