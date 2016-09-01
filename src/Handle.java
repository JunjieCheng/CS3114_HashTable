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

    /**
     * Compare this with obj.
     * 
     * @param obj   The object to be compared
     * @return return true if they are equal, else return false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        Handle other = (Handle) obj;
        
        if (pos != other.pos)
            return false;
        
        return true;
    }
}
