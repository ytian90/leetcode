package leetcode.design;

/**
 * 706. Design HashMap
 */
public class DesignHashMap {
    int[] arr;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        arr = new int[1000000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        arr[key] = value + 1; // in case value is 0
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (arr[key] == 0)
            return -1;
        return arr[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        arr[key] = 0;
    }
}
