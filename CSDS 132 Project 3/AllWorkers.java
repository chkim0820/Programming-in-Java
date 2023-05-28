/**
 * An abstract class overlooking the whole worker hierarchy.
 * @author Chaehyeon Kim
 */
public abstract class AllWorkers {
    /** Stores the first name of the worker */
    private String firstName;
    /** Stores the last name of the worker */
    private String lastName;
    /** Stores the number of the worker */
    private String number;
    /** Stores the bonus the worker receives */
    private double bonus;
    /** Stores the supervisor of the worker */
    private Supervisor supervisor;

    /** 
     * Creates a new AllWorkers.
     * @param firstName the first name of the worker
     * @param lastName  the last name of the worker
     * @param number  the number of the worker
     */
    public AllWorkers(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    /** 
     * Returns the first name of the worker
     * @return the first name of the worker
     */
    public String getFirstName() {
        return firstName;
    }

    /** 
     * Returns the last name of the worker.
     * @return the last name of the worker
     */
    public String getLastName() {
        return lastName;
    }

    /** 
     * Sets first and last name of the worker.
     * @param firstName  the first name to be set
     * @param lastName  the last name to be set
     */
    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /** 
     * Returns the number of the worker.
     * @return the number of the worker
     */
    public String getNumber() {
        return number;
    }

    /** 
     * Returns the bonus of the worker.
     * @return the bonus of the worker
     */
    public double getBonus() {
        return bonus;
    }

    /** 
     * Sets bonus for the worker.
     * @param bonus  the bonus of the worker
     */
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    /** 
     * Returns the total amount earned by the worker.
     * @return the total amount earned by the worker
     */
    public abstract double getAmountEarned();

    /** 
     * Compares this worker with the input worker to see if they are the same person
     * @param  worker the worker to be compared to the worker of the object
     * @return true if the two workers are the same, false if not
     */
    @Override
    public boolean equals(Object worker) {
        if (worker instanceof AllWorkers) {
            AllWorkers e = (AllWorkers) worker; // A variable to typecast worker from Object to AllWorkers
            return (this.getFirstName().equals(e.getFirstName()) &&
                this.getLastName().equals(e.getLastName()) &&
                this.getNumber().equals(e.getNumber()));
        } else
            return false;
    }

    /** 
     * Sets supervisor of the worker.
     * @param supervisor  the supervisor of the worker
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    /** 
     * Returns supervisor of the worker
     * @return supervisor of the worker
     */
    public Supervisor getSupervisor() {
        return supervisor;
    }
}