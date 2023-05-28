/* Chaehyeon Kim, a LibraryAccount class is the financial record of a library patron */

public class LibraryAccount extends Account {
  
  // a field for book fine
  private double bookFine;
  // a field for fine for reserved item
  private double reserveFine;
  // a field for # overdue books
  private int overdueBooks = 0;
  // a field for # overdue reserve items
  private int overdueReserve = 0;
  
  /* a constructor for LibraryAccount class*/
  public LibraryAccount(String accountNumber, int balanceLimit, double bookFine, double reserveFine) {
    super(accountNumber, balanceLimit);
    this.bookFine = bookFine;
    this.reserveFine = reserveFine;
  }
    
  /* 1a) a method that sets the amount overdue for a book */
  public void setBookFine(double bookFine) {
    this.bookFine = bookFine;
  }
  
  /* 1b) a method that returns the amount overdue for a book*/
  public double getBookFine() {
    return bookFine;
  }
  
  /* 1c) a method that sets the reserved item fine */
  public void setReserveFine(double reserveFine) {
    this.reserveFine = reserveFine; 
  }
  
  /* 1d) a method that returns the reserved item fine */
  public double getReserveFine() {
    return reserveFine; 
  }
  
  /* 1e) a method that increases # overdue books by 1 */
  public void incrementOverdueBooks() {
    overdueBooks = overdueBooks + 1;
  }
  
  /* 1f) a method that decreases # overdue books by 1 */
  public void decrementOverdueBooks() {
    if (overdueBooks > 0)
      overdueBooks = overdueBooks - 1;
  }
  
  /* 1g) a method that returns # overdue books */
  public int getNumberOverdueBooks() {
    return overdueBooks;
  }
  
  /* 1h) a method that increases increase # reserved item by 1 */
  public void incrementOverdueReserve() {
    overdueReserve = overdueReserve + 1;
  }
  
  /* 1i) a method that decreases # overdue reserved item by 1 */
  public void decrementOverdueReserve() {
    if (overdueReserve > 0)
      overdueReserve = overdueReserve - 1;
  }
  
  /* 1j) a method that returns # overdue reserved items*/
  public int getNumberOverdueReserve() {
    return overdueReserve;
  }
  
  /* 1k) a method that returns true if account's balance didn't exceed limit*/
  public boolean canBorrow() {
    return getBalance() <= getBalanceLimit();
  }
  
  /* 1l) a method that increases the balance by book & reserved fine*/
  public void endOfDay() {
    charge((getNumberOverdueBooks() * getBookFine()) + (getNumberOverdueReserve() * getReserveFine()));
  }
  
}