package design;

/**
 * 705. Design HashSet
 */
public class DesignHashSet {

    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    /** Initialize your data structure here. */
    public DesignHashSet() {
        table = new boolean[buckets][];
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void add(int key) {
        int hashkey = hash(key);
        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public void remove(int key) {
        int hashkey = hash(key);
        if (table[hashkey] != null) {
            table[hashkey][pos(key)] = false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }
}
