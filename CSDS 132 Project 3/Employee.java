/**
 * An interface for workers who are classified as employee.
 * @author Chaehyeon Kim
 */
public interface Employee {

    /** 
     * Returns the first name of the worker
     * @return the first name of the worker
     */
    public abstract String getFirstName();

    /** 
     * Returns the last name of the worker.
     * @return the last name of the worker
     */
    public abstract String getLastName();

    /** 
     * Returns the number of the worker.
     * @return the number of the worker
     */
    public abstract String getNumber();

    /** 
     * Returns the total amount earned by the worker.
     * @return the total amount earned by the worker
     */
    public abstract double getAmountEarned();

    /** 
     * Compares this employee and e employee's names alphabetically
     * @param e  employee to be compared to this employee
     * @return 0, -1, or 1 according to how their names compare
     */
    default int compareToByName(Employee e) {
        if (this.getFirstName().equals(e.getFirstName()) &&
            this.getLastName().equals(e.getLastName()))
            return 0;
        else if (this.getFirstName().equals(e.getFirstName()))
            return (this.getLastName().compareToIgnoreCase(e.getLastName()));
        else
            return (this.getFirstName().compareToIgnoreCase(e.getFirstName()));
    }

    /** 
     * Compares this employee and e employee's earnings
     * @param e  employee to be compared to this employee
     * @return 0, -1, or 1 according to how their earnings
     */
    default int compareToByEarnings(Employee e) {
        if (this.getAmountEarned() < e.getAmountEarned())
            return -1;
        else if (this.getAmountEarned() > e.getAmountEarned())
            return 1;
        else
            return 0;
    }
}