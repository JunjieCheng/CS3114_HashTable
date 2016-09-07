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
     * Name of the HashTable.
     */
    private String name;

    /**
     * Create a new Hash table.
     * @param name Name of the HashTable.
     * @param size  Size of the Hash table
     */
    @SuppressWarnings("unchecked")
    public HashTable(String name, int size) {
        this.entries = new Entry[size];
        this.size = 0;
        this.name = name;
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
     */
    public void print() {
        for (int i = 0; i < this.capacity; i++) {
            if (this.entries[i] != null 
                    && this.entries[i].key != null) {
                System.out.println("|" + this.entries[i].key + "| " + i);
            }
        }

        System.out.println("total " + this.name.toLowerCase() 
            + "s: " + this.size);
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

            if (this.entries[i] != null 
                    && this.entries[i].key != null) {
                home = hash(this.entries[i].key, capacity);
                pos = home;

                for (int j = 1; temp[pos] != null; j++) {
                    pos = (home + j * j) % capacity;
                }

                temp[pos] = this.entries[i];
            }
        }

        this.entries = temp;
        System.out.println(name + " hash table size doubled.");
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
            if (this.entries[pos].key == null) {
                break;
            }
            if (key.equals(this.entries[pos].key)) {
                System.out.println("|" + key + "| duplicates " 
                        + "a record already in the "
                        + this.name.toLowerCase() + " database.");
                return false;
            }

            pos = (home + i * i) % capacity;
        }

        entries[pos] = e;
        size++;
        System.out.println("|" + key + "| is added to the "
                + this.name.toLowerCase() + " database.");
        return true;
    }

    /**
     * Search the given key and store the value in value.
     * 
     * @param key   The key to be searched.
     * @return  Return Handle if find, else return null.
     */
    public V search(K key) {
        int home = hash(key, capacity);
        int pos = home;

        for (int i = 1; this.entries[pos] != null; i++) {
            if (this.entries[pos].key != null 
                    && this.entries[pos].key.equals(key)) {
                return this.entries[pos].value;
            }
            pos = (home + i * i) % capacity;
        }

        return null;
    }

    /**
     * Remove the given key, and store value in value.
     * 
     * @param key   The key to be removed.
     * @return  Return Handle if find, else return null.
     */
    public V remove(K key) {
        int home = hash(key, capacity);
        int pos = home ;
        Entry<K, V> removed = new Entry<K, V>(null, null);

        for (int i = 1; this.entries[pos] != null; i++) {
            if (this.entries[pos].key != null 
                    && this.entries[pos].key.equals(key)) {
                V value = this.entries[pos].value;
                this.entries[pos] = removed;
                size--;
                System.out.println("|" + key + "| is removed from the "
                        + this.name.toLowerCase() + " database.");
                return value;
            }
            pos = (home + i * i) % capacity;
        }

        System.out.println("|" + key + "| does not exist in the " 
                + this.name.toLowerCase() + " database.");
        return null;
    }
    
    /**
     * Check size.
     */
    public void check() {
        if (size + 1 > capacity / 2) {
            expand();
        }
    }

}
