import student.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Test DList.
 * @author Junjie Cheng (cjunjie)
 * @version September 2, 2016
 */
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
    
    /**
     * Test searchBlock.
     */
    @Test
    public void testSearchBlock() {
        this.list.add(110, 10);
        this.list.add(130, 15);
        this.list.add(150, 50);
        assertEquals(this.list.searchBlock(10), 110);
        assertEquals(this.list.searchBlock(12), 130);
        assertEquals(this.list.searchBlock(35), 150);
    }
    
    /**
     * Test splitBlock.
     */
    @Test
    public void testSplitBlock() {
        this.list.splitBlock(0, 20);
        assertEquals(this.list.getSize(), 1);
        
        this.list.add(150, 10);
        this.list.splitBlock(150, 10);
        assertEquals(this.list.getSize(), 1);
    }

}
