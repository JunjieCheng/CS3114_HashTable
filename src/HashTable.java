import java.util.Iterator;

/**
 * Hash table for storing artists and songs.
 * 
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class HashTable implements Iterable<Handle> {

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

    /**
     * Add Handle to the end of the table.
     * 
     * @param handle    Handle to be added
     */
    public void add(Handle handle) {
        if (this.size == this.capacity) {
            expand();
        }

        this.handles[size] = handle;
        this.size++;
    }

    /**
     * Remove given Handle.
     * 
     * @param handle    The Handle to be removed
     * @return  return true if found, else return false.
     */
    public boolean remove(Handle handle) {
        for (int i = 0; i < this.size; i++) {
            if (this.handles[i].equals(handle)) {
                this.handles[i] = this.handles[this.size - 1];
                this.size--;

                return true;
            }
        }

        return false;
    }

    /**
     * Expand the capacity of array and copy the content.
     */
    private void expand() {
        Handle[] temp = new Handle[this.capacity * 2];

        for (int i = 0; i < this.size; i++) {
            temp[i] = this.handles[i];
        }

        this.handles = temp;
        this.capacity *= 2;
    }

    /**
     * @return Return an Iterator.
     */
    public Iterator<Handle> iterator() {
        return new HandleIterator();
    }

    /**
     * Iterator of Handle array.
     * 
     * @author Junjie Cheng (cjunjie)
     * @version August 31, 2016
     */
    private class HandleIterator implements Iterator<Handle> {

        /**
         * Index of array.
         */
        private int index;

        /**
         * Create a new Iterator.
         */
        public HandleIterator() {
            this.index = 0;
        }

        /**
         * @return Return next Handle. If these is no next, return null.
         */
        public Handle next() {
            if (hasNext()) {
                return handles[index++];
            }

            return null;
        }

        /**
         * @return Return true if has next Handle, else return false.
         */
        public boolean hasNext() {
            return index < size;
        }

    }
}
