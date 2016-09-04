
public class Handle {
    
    /*
     * Position in memory pool.
     */
    private int pos;

    /**
     * Create a new Handle.
     * 
     * @param pos   Position
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
