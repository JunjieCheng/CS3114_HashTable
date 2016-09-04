/**
 * Memory manager.
 * @author Junjie Cheng (cjunjie)
 * @version September 2, 2016
 */
public class MemManager {

    /**
     * Memory pool.
     */
    private byte[] pool;

    /**
     * Free blocks list.
     */
    private DList freeBlocks;

    /**
     * Create a new Memory manager.
     * @param size  Size of memory pool.
     */
    public MemManager(int size) {
        this.pool = new byte[size];
        this.freeBlocks = new DList(size);
    }

    /**
     * Insert a String to memory pool.
     * @param str String
     * @return  Return a Handle of the String
     */
    public Handle insert(String str) {
        byte[] length = new byte[] {
                (byte)(str.length() >> 8),
                (byte)str.length()
        };
        byte[] string = str.getBytes();
        int pos = this.freeBlocks.searchBlock(str.length() + 2);

        this.pool[pos] = length[0];
        this.pool[pos+1] = length[1];

        for (int i = 0; i < str.length(); i++) {
            this.pool[pos + i + 2] = string[i];
        }

        return new Handle(pos);
    }

    /**
     * Remove a String from memory pool.
     * @param h Handle
     * @return Return true if removed, else return false.
     */
    public boolean remove(Handle h) {
        return false;
    }

    /**
     * Print free blocks list.
     */
    public void print() {
        //TODO
    }
}
