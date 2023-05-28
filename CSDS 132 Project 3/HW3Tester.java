/**
 * A class containing all the test codes for CSDS 132 project #3.
 * @author Chaehyeon Kim
 */
import org.junit.*;
import static org.junit.Assert.*;

public class HW3Tester {

    /** 
     * Tests if getFirstName returns the first name of this worker
     */
    @Test
    public void testGetFirstName() {
        SalariedSupervisor worker = new SalariedSupervisor("Chae", "Kim", "1", 1000000.0);
        assertEquals("The test for the getFirstName fails", "Chae", worker.getFirstName());
    }
}