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
        this.h1 = new Handle(0, 1);
        this.h2 = new Handle(1, 2);
        this.h3 = new Handle(0, 1);
    }

    /**
     * Test pos.
     */
    @Test
    public void testPos() {
        assertEquals(h1.pos(), 0);
        assertEquals(h2.pos(), 1);
    }
    
    /**
     * Test len.
     */
    public void testLen() {
        assertEquals(h1.len(), 1);
        assertEquals(h2.len(), 2);
    }
    
    /**
     * Test equals.
     */
    public void testEquals() {
        assertFalse(h1.equals(hNull));
        assertTrue(h1.equals(h1));
        assertFalse(h1.equals(new Integer(1)));
        assertFalse(h1.equals(h2));
        assertTrue(h1.equals(h3));
    }

}
