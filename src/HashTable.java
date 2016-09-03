import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Hash table for storing artists and songs.
 * @author Junjie Cheng (cjunjie)
 * @version August 31, 2016
 * 
 * @param <K> key
 * @param <V> value
 */
public class HashTable<K, V> {

    /**
     * Entry.
     * @author Junjie Cheng (cjunjie)
     *
     * @param <K> key
     * @param <V> value
     */
    @SuppressWarnings("hiding")
    class Entry<K, V> {

        /**
         * Key.
         */
        public K key;

        /**
         * Value.
         */
        public V value;

        /**
         * Create a new Entry.
         * @param key   key.
         * @param value Value.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Array for Entry.
     */
    private Entry<K, V>[] entries;

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
    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.entries = new Entry[size];
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
     * Print all keys.
     * @param f File for output.
     * @param name  Name of the HashTable
     * @throws IOException  File not found Exception.
     */
    public void print(BufferedWriter f, String name) throws IOException {
        for (int i = 0; i < this.capacity; i++) {
            if (this.entries[i] != null) {
                f.write("|" + this.entries[i].key + "| " + i + "\n");
            }
        }

        f.write("total " + name + "s: " + this.size + "\n");
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Expand the HashTable when size is half of the capacity.
     */
    private void expand() {
        @SuppressWarnings("unchecked")
        Entry<K, V>[] temp = new Entry[this.capacity * 2];
        this.capacity *= 2;

        for (int i = 0; i < capacity / 2; i++) {
            int home;
            int pos;

            if (this.entries[i] != null) {
                home = hash(this.entries[i].key, capacity);
                pos = home;

                for (int j = 1; temp[pos] != null; j++) {
                    pos = (home + j * j) % capacity;
                }

                temp[pos] = this.entries[i];
            }
        }

        this.entries = temp;
    }

    /**
     * Calculate the hash code through key.
     * 
     * @param key   The key to be calculated.
     * @param m     The capacity of HashTable.
     * @return      The hash code.
     */
    private int hash(K key, int m)
    {
        if (key.getClass() == String.class) {
            String s = (String)key;
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

        throw new IllegalArgumentException();
    }

    /**
     * Insert the entry to HashTable.
     * 
     * @param key   The key of the entry.
     * @param value The value of the entry.
     * @return Return true if be added, else return false.
     */
    public boolean insert(K key, V value) {
        if (size + 1 > capacity / 2) {
            expand();
        }

        @SuppressWarnings({ "rawtypes", "unchecked" })
        Entry<K, V> e = new Entry(key, value);

        int home = hash(key, capacity);
        int pos = home;

        for (int i = 1; this.entries[pos] != null; i++) {
            if (this.entries[pos] != null && 
                    key.equals(this.entries[pos].key)) {
                System.out.println("Duplicates not allowed");
                return false;
            }

            pos = (home + i * i) % capacity;
        }

        entries[pos] = e;
        size++;
        return true;
    }

    /**
     * Search the given key and store the value in value.
     * 
     * @param key   The key to be searched.
     * @param value Store value.
     * @return  Return true if find, else return false.
     */
    public boolean search(K key, V value) {
        int home = hash(key, capacity);
        int pos = home;

        for (int i = 1; entries[pos] != null && 
                !entries[pos].key.equals(key); i++) {
            pos = (home + i * i) % capacity;
        }

        if (entries[pos] != null && entries[pos].key.equals(key)) {
            value = entries[pos].value;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Remove the given key, and store value in value.
     * 
     * @param key   The key to be removed.
     * @param value Store the value.
     * @return  Return true if find, else return false.
     */
    public boolean remove(K key, V value) {
        int home = hash(key, capacity);
        int pos = home ;

        for (int i = 1; entries[pos] != null && 
                !entries[pos].key.equals(key); i++) {
            pos = (home + i * i) % capacity;
        }

        if (entries[pos] != null && entries[pos].key.equals(key)) {
            value = entries[pos].value;
            entries[pos] = null;
            size--;

            return true;
        }
        else {
            return false;
        }
    }

}
