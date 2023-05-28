/**
 * An interface for workers who are classified as supervisors.
 * @author Chaehyeon Kim
 */
public interface Supervisor {

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
     * Compares this supervisor and e supervisor's names alphabetically
     * @param s  supervisor to be compared to this supervisor
     * @return 0, -1, or 1 according to how their names compare
     */
    default int compareToByName(Supervisor s) {
        if (this.getFirstName().equals(s.getFirstName()) &&
            this.getLastName().equals(s.getLastName()))
            return 0;
        else if (this.getFirstName().equals(s.getFirstName()))
            return (this.getLastName().compareToIgnoreCase(s.getLastName()));
        else
            return (this.getFirstName().compareToIgnoreCase(s.getFirstName()));
    }

    /** 
     * Compares this supervisor and e supervisor's earnings
     * @param e  supervisor to be compared to this supervisor
     * @return 0, -1, or 1 according to how their earnings
     */
    default int compareToByEarnings(Supervisor s) {
        if (this.getAmountEarned() < s.getAmountEarned())
            return -1;
        else if (this.getAmountEarned() > s.getAmountEarned())
            return 1;
        else
            return 0;
    }
}