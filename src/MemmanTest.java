import java.io.IOException;

import student.TestCase;



public class MemmanTest extends TestCase {
    
    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        // Nothing Here
    }

    /**
     * Get code coverage of the class declaration.
     */
    public void testMInit() {
        Memman mem = new Memman();
        assertNotNull(mem);
        
        try {
            Memman.main(new String[] {"100", "1000", "P1sampleInput.txt"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
