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
        this.table = new HashTable<String, Handle>("Test", 10);
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
     * Test insert.
     */
    @Test
    public void testInsert() {
        // Test duplicate and collision case.
        this.table.insert("aaaabbbb", new Handle(0));
        this.table.insert("aaaabbbb", new Handle(0));
        this.table.insert("bbbbaaaa", new Handle(10));
        assertEquals(this.table.getSize(), 2);

        // Test removed collision case.
        this.table.remove("aaaabbbb", new Handle(0));
        assertEquals(this.table.getSize(), 1);
        Handle h = null;
        this.table.insert("aaaabbbb", new Handle(0));
        h = this.table.search("aaaabbbb");
        assertEquals(h.getPos(), 0);

        // Test hash
        HashTable<Integer, Handle> intTable = new HashTable<Integer, Handle>("Test", 10);
        try {
            intTable.insert(1, new Handle(0));
        }
        catch (Exception e) {
            assertNotNull(e);
        }
    }

    /**
     * Test expand.
     */
    @Test
    public void testExpand() {
        Handle h = new Handle(0);
        this.table.insert("aaaabbbb", h);
        this.table.insert("bbbbaaaa", h);
        this.table.insert("bbbbcccc", h);
        this.table.insert("ccccbbbb", h);
        this.table.insert("ccccdddd", h);
        this.table.insert("ddddcccc", h);

        assertEquals(this.table.getCapacity(), 20);
    }

    /**
     * Test search.
     */
    @Test
    public void testSearch() {
        for (int i = 0; i < 5; i++) {
            this.table.insert(i + "", new Handle(i));
        }

        assertNotNull(this.table.search( "1"));
        assertNull(this.table.search("a"));
    }

    /**
     * Test remove.
     */
    @Test
    public void testRemove() {
        for (int i = 0; i < 5; i++) {
            this.table.insert(i + "", new Handle(i));
        }

        Handle res = null;
        assertTrue(this.table.remove("1", res));
        assertEquals(this.table.getSize(), 4);
        assertFalse(this.table.remove("a", res));
    }
}
