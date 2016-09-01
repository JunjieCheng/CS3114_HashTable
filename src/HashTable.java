/**
 * Hash table for storing artists and songs.
 * 
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 */

public class HashTable {
    
    private Handle[] handles;
    private int size;
    private int capacity;
    
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

    public void add(Handle handle) {
        if (this.size == this.capacity) {
            expand();
        }
        
        this.handles[size] = handle;
        this.size++;
    }
    
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
    
    public void expand() {
        Handle[] temp = new Handle[this.capacity * 2];
        
        for (int i = 0; i < this.size; i++) {
            temp[i] = this.handles[i];
        }
        
        this.handles = temp;
        this.capacity *= 2;
    }
    
    public void print() {
        
    }
}
