/**
 * A class for salaried employees.
 * @author Chaehyeon Kim
 */
public class SalariedEmployee extends SalaryWorkers implements Employee {

    /** 
     * Creates a new SalariedEmployee.
     * @param firstName the first name of the salaried employee
     * @param lastName  the last name of the salaried employee
     * @param number  the number of the salaried employee
     * @param hourlyRate  the salary of the salaried employee
     */
    public SalariedEmployee(String firstName, String lastName, String number, double salary) {
        super(firstName, lastName, number, salary);
    }

    /** 
     * Overrides the Object toString method to return "number: last name, first name, Salaried Employee"
     */
    @Override
    public String toString() {
        return getNumber() + ": " + getLastName() + ", " + getFirstName() + ", " + "Salaried Employee";
    }
}