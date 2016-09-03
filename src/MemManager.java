
public class MemManager {
    
    private byte[] pool;
    private DList freeBlocks;

    public MemManager(int size) {
        this.pool = new byte[size];
        this.freeBlocks = new DList(size);
    }
    
    public Handle insert(String str) {
        return null;
    }
    
    public boolean remove(Handle h) {
        return false;
    }
    
    public void print() {
        
    }
}
