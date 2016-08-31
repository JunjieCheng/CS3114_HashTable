
public class MemManager {
    
    private byte[] pool;

    public MemManager(int size) {
        this.pool = new byte[size];
    }
}
