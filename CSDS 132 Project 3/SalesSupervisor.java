/**
 * A class for sales supervisors.
 * @author Chaehyeon Kim
 */
public class SalesSupervisor extends SalesWorkers implements Supervisor {

    /** 
     * Creates a new SalesSupervisor.
     * @param firstName the first name of the sales supervisor
     * @param lastName  the last name of the sales supervisor
     * @param number  the number of the sales supervisor
     * @param hourlyRate  the hourly rate of the sales supervisor
     * @param commission  the commission of the sales supervisor
     */
    public SalesSupervisor(String firstName, String lastName, String number, double salary, double commission) {
        super(firstName, lastName, number, salary, commission);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Sales Supervisor"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Sales Supervisor";
    }

}