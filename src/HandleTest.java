import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import student.TestCase;

public class HandleTest extends TestCase {
    
    private Handle h1, h2;

    @Before
    public void setUp() throws Exception {
        this.h1 = new Handle(0, 1);
        this.h2 = new Handle(1, 2);
    }

    @Test
    public void testPos() {
        assertEquals(h1.pos(), 0);
        assertEquals(h2.pos(), 1);
    }
    
    public void testLen() {
        assertEquals(h1.len(), 1);
        assertEquals(h2.len(), 2);
    }
    
    public void testEquals() {
        
    }

}
