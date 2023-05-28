/**
 * A class for hourly employees.
 * @author Chaehyeon Kim
 */
public class HourlyEmployee extends HourlyWorkers implements Employee {

    /** 
     * Creates a new HourlyEmployee.
     * @param firstName the first name of the hourly employee 
     * @param lastName  the last name of the hourly employee
     * @param number  the number of the hourly employee
     * @param hourlyRate  the hourly rate of the hourly employee
     */
    public HourlyEmployee(String firstName, String lastName, String number, double hourlyRate) {
        super(firstName, lastName, number, hourlyRate);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Hourly Employee"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Hourly Employee";
    }
}