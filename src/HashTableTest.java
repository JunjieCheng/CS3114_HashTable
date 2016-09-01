import static org.junit.Assert.*;
import java.util.Iterator;
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
    private HashTable table;
    
    /**
     * Initialize objects.
     */
    @Before
    public void setUp() throws Exception {
        this.table = new HashTable(5);
    }

    /**
     * Test getSize.
     */
    @Test
    public void testGetSize() {
        assertEquals(table.getSize(), 0);
        
        table.add(new Handle(0, 0));
        assertEquals(table.getSize(), 1);
    }
    
    /**
     * Test getCapacity.
     */
    @Test
    public void testGetCapacity() {
        assertEquals(table.getCapacity(), 5);
    }
    
    /**
     * Test Add.
     */
    @Test
    public void testAdd() {
        for (int i = 0; i < 6; i++) {
            table.add(new Handle(i, 1));
        }
        
        assertEquals(table.getSize(), 6);
    }
    
    /**
     * Test Remove.
     */
    @Test
    public void testRemove() {
        for (int i = 0; i < 5; i++) {
            table.add(new Handle(i, 1));
        }
        
        assertTrue(table.remove(new Handle(2, 1)));
        assertFalse(table.remove(new Handle(0, 2)));
    }
    
    /**
     * Test Iterator.
     */
    @Test
    public void testIterator() {
        for (int i = 0; i < 2; i++) {
            table.add(new Handle(i, 1));
        }
        
        Iterator<Handle> iterator = table.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Handle(0, 1));
        assertEquals(iterator.next(), new Handle(1, 1));
        assertFalse(iterator.hasNext());
        assertEquals(iterator.next(), null);
    }

}
