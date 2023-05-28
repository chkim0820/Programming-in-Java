/**
 * A class of linked list that keeps the database of all workers.
 * @author Chaehyeon Kim
 */
public class EmployeeDatabase {
    /** stores the linked list of the EmployeeDatabase*/
    private LinkedList<AllWorkers> list;

    /** 
     * adds the input worker to the database
     * @param worker  worker to be added to the database
     */
    public void add(AllWorkers worker) {
        list.addToEnd(worker);
    }

    /** 
     * Removes the worker according to the input parameter and returns that worker from the database
     * @param firstName  the first name of the worker to be removed
     * @param lastName  the last name of the worker to be removed
     * @param number  the number of the worker to be removed
     * @return the worker removed
     * @throws NoSuchEmployeeException if there is no employee of the input information
     */
    public AllWorkers remove(String firstName, String lastName, String number) {
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // nodeptr that tracks which node we're at
        LLNode < AllWorkers > lastNode = null; // saves the last node
        while (nodeptr != null) { // goes through the database to find the worker to be removed
            AllWorkers w = nodeptr.getElement(); // worker at nodeptr
            if (w.getFirstName() == firstName && w.getLastName() == lastName && w.getNumber() == number) {
                if (lastNode == null)
                    list = null;
                else
                    lastNode.setNext(nodeptr.getNext());
                return w;
            }
            lastNode = nodeptr;
            nodeptr = nodeptr.getNext();
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Find the worker according to the input parameter and returns that worker from the database
     * @param firstName  the first name of the worker to be removed
     * @param lastName  the last name of the worker to be removed
     * @param number  the number of the worker to be removed
     * @return the worker found
     * @throws NoSuchEmployeeException if there is no employee of the input information
     */
    public AllWorkers find(String firstName, String lastName, String number) {
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // nodeptr that tracks which node we're at
        AllWorkers save = null; // worker to be returned
        while (nodeptr != null) {
            AllWorkers w = nodeptr.getElement();
            if (w.getFirstName() == firstName && w.getLastName() == lastName && w.getNumber() == number) {
                save = w;
                return save;
            }
            nodeptr = nodeptr.getNext();
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Returns the total payroll of everyone in the database
     * @return the total payroll of everyone in the database
     */
    public double getPayrollAmount() {
        double total = 0.0; // tracks total amount
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // nodeptr that tracks which node we're at
        while (nodeptr != null) {
            total += nodeptr.getElement().getAmountEarned();
            nodeptr = nodeptr.getNext();
        }
        return total;
    }

    /** 
     * Returns the worker who earned the most in the database
     * @return the worker who earned the most in the database
     */
    public AllWorkers getMaximumEarned() {
        double max = 0.0; // current maximum amount earned
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers maxEarner = null; // current maximum earner
        while (nodeptr != null) {
            if (nodeptr.getElement().getAmountEarned() > max) {
                max = nodeptr.getElement().getAmountEarned();
                maxEarner = nodeptr.getElement();
            }
            nodeptr = nodeptr.getNext();
        }
        return maxEarner;
    }

    /** 
     * Returns the worker who earned the least in the database
     * @return the worker who earned the least in the database
     */
    public AllWorkers getMinimumEarned() {
        double min = 0.0; // current minimum amount earned
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers minEarner = null; // current minimum earner
        while (nodeptr != null) {
            if (nodeptr.getElement().getAmountEarned() < min) {
                min = nodeptr.getElement().getAmountEarned();
                minEarner = nodeptr.getElement();
            }
            nodeptr = nodeptr.getNext();
        }
        return minEarner;
    }

    /** 
     * Returns the worker who made the most sales in the database
     * @return the worker who made the most sales in the database
     * @throws NoSuchEmployeeException if there's no sales worker
     */
    public AllWorkers getMaxSales() {
        int max = 0; // current maximum number of sales
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers maxSales = null; // current maximum sales person
        while (nodeptr != null) {
            if (nodeptr.getElement() instanceof SalesWorkers) {
                SalesWorkers worker = (SalesWorkers) nodeptr.getElement();
                if (worker.getNumSales() >= max) {
                    max = worker.getNumSales();
                    maxSales = worker;
                }
            }
            nodeptr = nodeptr.getNext();
            if (nodeptr.getNext() == null)
                return maxSales;
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Returns the worker who made the least sales in the database
     * @return the worker who made the least sales in the database
     * @throws NoSuchEmployeeException if there's no sales worker
     */
    public AllWorkers getMinSales() {
        int min = 0; // current minimum number of sales
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers minSales = null; // current minimum sales person
        while (nodeptr != null) {
            if (nodeptr.getElement() instanceof SalesWorkers) {
                SalesWorkers worker = (SalesWorkers) nodeptr.getElement();
                if (worker.getNumSales() <= min) {
                    min = worker.getNumSales();
                    minSales = worker;
                }
            }
            nodeptr = nodeptr.getNext();
            if (nodeptr.getNext() == null)
                return minSales;
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Returns the worker who worked the most number of hours in the database
     * @return the worker who worked the most number of hours in the database
     * @throws NoSuchEmployeeException if there's no hourly worker
     */
    public AllWorkers getMaxHoursWorked() {
        double max = 0.0; // curent maximum number of hours worked
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers maxHours = null; // current person with maximum hours worked
        while (nodeptr != null) {
            if (nodeptr.getElement() instanceof HourlyWorkers) {
                HourlyWorkers worker = (HourlyWorkers) nodeptr.getElement();
                if (worker.getHoursWorked() >= max) {
                    max = worker.getHoursWorked();
                    maxHours = worker;
                }
            }
            nodeptr = nodeptr.getNext();
            if (nodeptr.getNext() == null)
                return maxHours;
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Returns the worker who worked the least number of hours in the database
     * @return the worker who worked the least number of hours in the database
     * @throws NoSuchEmployeeException if there's no hourly worker
     */
    public AllWorkers getMinHoursWorked() {
        double min = 0; // current minimum number of hours worked
        LLNode < AllWorkers > nodeptr = list.getFirstNode(); // current node we're at
        AllWorkers minHours = null; // current person with minimum hours worked
        while (nodeptr != null) {
            if (nodeptr.getElement() instanceof HourlyWorkers) {
                HourlyWorkers worker = (HourlyWorkers) nodeptr.getElement();
                if (worker.getHoursWorked() <= min) {
                    min = worker.getHoursWorked();
                    minHours = worker;
                }
            }
            nodeptr = nodeptr.getNext();
            if (nodeptr.getNext() == null)
                return minHours;
        }
        throw new NoSuchEmployeeException();
    }

    /** 
     * Returns the array that stores all supervisees of the input supervisor
     * @return the array that stores all supervisees of the input supervisor
     * @param supervisor  the supervisor of the supervisees in the returned array
     */
    public AllWorkers[] getSupervisees(Supervisor supervisor) {
        LLNode < AllWorkers > nodeptr = list.getFirstNode();
        int numSupervisees = 0;
        while (nodeptr != null) {
            if (nodeptr.getElement().getSupervisor().equals(supervisor)) {
                numSupervisees = numSupervisees + 1;
            }
            nodeptr = nodeptr.getNext();
        }
        AllWorkers[] array = new AllWorkers[numSupervisees];
        int i = 0;
        while (nodeptr != null) {
            if (nodeptr.getElement().getSupervisor().equals(supervisor)) {
                array[i] = nodeptr.getElement();
                i++;
            }
        }
        return array;
    }
}