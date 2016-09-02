import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * Test unit of class HashTable.
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class HashTableTest extends TestCase {

    /**
     * Objects for the test.
     */
    private HashTable<String, Handle> table;
    
    /**
     * Initialize objects.
     */
    @Before
    public void setUp() throws Exception {
        this.table = new HashTable<String, Handle>(10);
    }

    /**
     * Test getSize.
     */
    @Test
    public void testGetSize() {
        assertEquals(table.getSize(), 0);
    }
    
    /**
     * Test getCapacity.
     */
    @Test
    public void testGetCapacity() {
        assertEquals(table.getCapacity(), 10);
    }
    
    /**
     * Test expand.
     */
    @Test
    public void testExpand() {
        for (int i = 0; i < 6; i++) {
            this.table.insert(i + "", new Handle(i));
        }
        
        assertEquals(this.table.getCapacity(), 10);
    }
    
}
