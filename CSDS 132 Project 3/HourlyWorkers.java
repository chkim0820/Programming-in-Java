/**
 * An abstract class for hourly workers.
 * @author Chaehyeon Kim
 */
public abstract class HourlyWorkers extends AllWorkers {
    /** stores hourly rate of the hourly worker*/
    private double hourlyRate = 0.0;
    /** stores the hours worked of the hourly worker*/
    private double hoursWorked = 0.0;

    /** 
     * Creates a new HourlyWorkers.
     * @param firstName the first name of the hourly worker
     * @param lastName  the last name of the hourly worker
     * @param number  the number of the hourly worker
     * @param hourlyRate  the hourly rate of the hourly worker
     */
    public HourlyWorkers(String firstName, String lastName, String number, double hourlyRate) {
        super(firstName, lastName, number);
        this.hourlyRate = hourlyRate;
    }

    /** 
     * Returns the hourly rate of the hourly worker
     * @return the hourly rate of the hourly worker
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /** 
     * Sets hourly rate of the hourly worker.
     * @param rate  the hourly rate of the hourly worker
     */
    public void setHourlyRate(double rate) {
        this.hourlyRate = rate;
    }

    /** 
     * Returns the hours worked of the hourly worker
     * @return the hours worked of the hourly worker
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /** 
     * Sets hours worked of the hourly worker.
     * @param hoursWorked  the hours worked of the hourly worker
     */
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /** 
     * Returns the total amount earned
     * @return the total amount earned
     */
    public double getAmountEarned() {
        return (getHourlyRate() * getHoursWorked()) + getBonus();
    }

    /** 
     * Adjusts the pay by the input percentage
     * @param percentage  percentage to adjust the pay to 
     */
    public void adjustPay(double percentage) {
        setHourlyRate(getHourlyRate() + getHourlyRate() * (percentage / 100));
    }
}