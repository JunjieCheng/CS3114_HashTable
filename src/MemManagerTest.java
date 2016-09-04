import org.junit.Before;
import org.junit.Test;
import student.TestCase;


public class MemManagerTest extends TestCase {
    
    /**
     * Object for the test.
     */
    private MemManager pool;

    /**
     * Set up.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        this.pool = new MemManager(1000);
    }
    
    /**
     * Test insert.
     */
    @Test
    public void testInsert() {
        assertEquals(this.pool.insert("a").getPos(), 0);
    }

}
