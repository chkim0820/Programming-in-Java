/**
 * A class for hourly supervisors.
 * @author Chaehyeon Kim
 */
public class HourlySupervisor extends HourlyWorkers implements Supervisor {

    /** 
     * Creates a new HourlySupervisor.
     * @param firstName the first name of the hourly supervisor 
     * @param lastName  the last name of the hourly supervisor
     * @param number  the number of the hourly supervisor
     * @param hourlyRate  the hourly rate of the hourly supervisor
     */
    public HourlySupervisor(String firstName, String lastName, String number, double hourlyRate) {
        super(firstName, lastName, number, hourlyRate);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Hourly Supervisor"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Hourly Supervisor";
    }
}