import static org.junit.Assert.*;
import student.TestCase;
import org.junit.Before;
import org.junit.Test;

public class DListTest extends TestCase {

    /**
     * DList.
     */
    private DList list;
    
    /**
     * Set up.
     */
    @Before
    public void setUp() throws Exception {
        this.list = new DList(100);
    }
    
    /**
     * Test getSize.
     */
    @Test
    public void testGetSize() {
        assertEquals(this.list.getSize(), 1);
    }

    /**
     * Test Add.
     */
    @Test
    public void testAdd() {
        this.list.add(110, 10);
        this.list.add(100, 10);
        assertEquals(this.list.getSize(), 1);
    }

}
