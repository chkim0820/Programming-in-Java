/**
 * A class for salaried supervisors.
 * @author Chaehyeon Kim
 */
public class SalariedSupervisor extends SalaryWorkers implements Supervisor {

    /** 
     * Creates a new SalariedSupervisor.
     * @param firstName the first name of the salaried supervisor
     * @param lastName  the last name of the salaried supervisor
     * @param number  the number of the salaried supervisor
     * @param hourlyRate  the salary of the salaried supervisor
     */
    public SalariedSupervisor(String firstName, String lastName, String number, double salary) {
        super(firstName, lastName, number, salary);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Salaried Supervisor"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Salaried Supervisor";
    }

}