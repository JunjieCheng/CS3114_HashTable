
public class HashTable {
    
    private Handle[] handles;
    private int size;
    private int capacity;
    
    public HashTable(int size) {
        this.handles = new Handle[size];
        this.size = 0;
        this.capacity = size;
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
}
