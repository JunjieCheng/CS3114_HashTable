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
     * Size that expand every time.
     */
    private int expandSize;

    /**
     * Create a new Memory manager.
     * @param size  Size of memory pool.
     */
    public MemManager(int size) {
        this.pool = new byte[size];
        this.freeBlocks = new DList(size);
        this.expandSize = size;
    }

    /**
     * Insert a String to memory pool.
     * @param str String
     * @return  Return a Handle of the String
     */
    public Handle insert(String str) {
        int pos = this.freeBlocks.searchBlock(str.length() + 2);

        if (pos == -1) {
            int newPos = this.pool.length;
            expand();
            this.freeBlocks.add(newPos, this.expandSize);
            pos = this.freeBlocks.searchBlock(str.length() + 2);
        }

        byte[] length = new byte[] {
            (byte)(str.length() >> 8),
            (byte)str.length()
        };
        byte[] string = str.getBytes();

        this.pool[pos] = length[0];
        this.pool[pos + 1] = length[1];

        for (int i = 0; i < str.length(); i++) {
            this.pool[pos + i + 2] = string[i];
        }

        return new Handle(pos);
    }

    /**
     * Expand the memory pool when it is full.
     */
    public void expand() {
        byte[] temp = new byte[this.pool.length + this.expandSize];

        for (int i = 0; i < this.pool.length; i++) {
            temp[i] = this.pool[i];
        }

        this.pool = temp;
        System.out.println("Memory pool expanded to be " + this.pool.length
                + " bytes");
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
