/**
 * An abstract class for salary workers.
 * @author Chaehyeon Kim
 */
public abstract class SalaryWorkers extends AllWorkers {
    /** stores the salary of the salary worker*/
    private double salary;

    /** 
     * Creates a new SalaryWorker.
     * @param firstName the first name of the salary worker
     * @param lastName  the last name of the salary worker
     * @param number  the number of the salary worker
     * @param hourlyRate  the salary of the salary worker
     */
    public SalaryWorkers(String firstName, String lastName, String number, double salary) {
        super(firstName, lastName, number);
        this.salary = salary;
    }

    /** 
     * Returns the salary of the salary worker
     * @return the salary of the salary worker
     */
    public double getSalary() {
        return salary;
    }

    /** 
     * Sets salary of the salary worker.
     * @param salary  the salary of the salary worker
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /** 
     * Returns the total amount earned
     * @return the total amount earned
     */
    public double getAmountEarned() {
        return getSalary() + getBonus();
    }

    /** 
     * Adjusts the pay by the input percentage
     * @param percentage  percentage to adjust the pay to 
     */
    public void adjustPay(double percentage) {
        setSalary(getSalary() + (getSalary() * percentage / 100));
    }
}