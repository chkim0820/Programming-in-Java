/**
 * A class for sales workers.
 * @author Chaehyeon Kim
 */
public class SalesEmployee extends SalesWorkers implements Employee {

    /** 
     * Creates a new SalesEmployee.
     * @param firstName the first name of the sales employee
     * @param lastName  the last name of the sales employee
     * @param number  the number of the sales employee
     * @param hourlyRate  the hourly rate of the sales employee
     * @param commission  the commission of the sales employee
     */
    public SalesEmployee(String firstName, String lastName, String number, double salary, double commission) {
        super(firstName, lastName, number, salary, commission);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Sales Employee"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Sales Employee";
    }
}