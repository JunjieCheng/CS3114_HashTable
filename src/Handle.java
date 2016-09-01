/**
 * Handle of HashTable class
 *
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class Handle {
    
    /*
     * Position in memory pool.
     */
    private int pos;

    /**
     * Create a new Handle.
     * 
     * @param pos   Position
     * @param len   Length
     */
    public Handle(int pos) {
        this.pos = pos;
    }

    /**
     * Return the Position.
     * 
     * @return pos
     */
    public int getPos() {
        return pos;
    }
    
}
