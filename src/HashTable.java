import java.util.Iterator;

/**
 * Hash table for storing artists and songs.
 * 
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class HashTable {

    /**
     * Array for Handle.
     */
    private Handle[] handles;

    /**
     * Size of array.
     */
    private int size;

    /**
     * Capacity of array.
     */
    private int capacity;

    /**
     * Create a new Hash table.
     * @param size  Size of the Hash table
     */
    public HashTable(int size) {
        this.handles = new Handle[size];
        this.size = 0;
        this.capacity = size;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }
    
    private int hash(String s, int m)
    {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++)
        {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++)
            {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++)
        {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % m);
    }

}
