import java.io.IOException;

import student.TestCase;

/**
 * @author Junjie Cheng(cjunjie) Liang Shi(blairshi)
 * @version 0.1
 */

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
            Memman.main(new String[] {"10", "32", "P1sampleInput.txt"});
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
