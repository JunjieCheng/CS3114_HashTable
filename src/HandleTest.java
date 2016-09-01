import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * Test unit of class Handle
 * 
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class HandleTest extends TestCase {
    
    /**
     * Objects for testing.
     */
    private Handle h1, h2, h3, hNull;
    
    /**
     * Set up.
     */
    @Before
    public void setUp() throws Exception {
        this.h1 = new Handle(0);
        this.h2 = new Handle(1);
        this.h3 = new Handle(0);
    }

    /**
     * Test pos.
     */
    @Test
    public void testGetPos() {
        assertEquals(h1.getPos(), 0);
        assertEquals(h2.getPos(), 1);
    }

}
