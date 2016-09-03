import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemManagerTest {
    
    /**
     * Object for the test.
     */
    private MemManager pool;

    @Before
    public void setUp() throws Exception {
        this.pool = new MemManager(1000);
    }

}
