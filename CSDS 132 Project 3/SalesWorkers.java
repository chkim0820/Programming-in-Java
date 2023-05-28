/**
 * An abstract class for sales workers.
 * @author Chaehyeon Kim
 */
public abstract class SalesWorkers extends SalaryWorkers {
    /** stores the commission of salary worker */
    private double commission;
    /** stores the number of sales of salary worker */
    private int numSales;

    /** 
     * Creates a new SalesWorkers.
     * @param firstName the first name of the sales worker
     * @param lastName  the last name of the sales worker
     * @param number  the number of the sales worker
     * @param hourlyRate  the hourly rate of the sales worker
     * @param commission  the commission of the sales worker
     */
    public SalesWorkers(String firstName, String lastName, String number, double salary, double commission) {
        super(firstName, lastName, number, salary);
        this.commission = commission;
    }

    /** 
     * Returns the commission of the sales worker
     * @return the commission of the sales worker
     */
    public double getCommission() {
        return commission;
    }

    /** 
     * Sets commission of the sales worker.
     * @param commission  the commission of the sales worker
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }

    /** 
     * Returns the number of sales of the sales worker
     * @return the number of sales of the sales worker
     */
    public int getNumSales() {
        return numSales;
    }

    /** 
     * Sets the number of sales of the sales worker.
     * @param commission  the number of sales of the sales worker
     */
    public void setNumSales(int numSales) {
        this.numSales = numSales;
    }

    /** 
     * Returns the total amount earned
     * @return the total amount earned
     */
    public double getAmountEarned() {
        return (getSalary() + (getCommission() * getNumSales()) + getBonus());
    }

    /** 
     * Adjusts the pay by the input percentage
     * @param percentage  percentage to adjust the pay to 
     */
    public void adjustPay(double percentage) {
        setCommission(getCommission() + (getCommission() * (percentage / 100)));
    }

}