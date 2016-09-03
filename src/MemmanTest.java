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
        Memman.main(null);
    }
}
