package company.uuba;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 460. LFU Cache
 *
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 * void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
 * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Example 1:
 *
 * Input
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 *
 * Explanation
 * // cnt(x) = the use counter for key x
 * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // return 1
 *                  // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
 *                  // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
 *                  // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // return -1 (not found)
 * lfu.get(3);      // return 3
 *                  // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // return 4
 *                  // cache=[3,4], cnt(4)=2, cnt(3)=3
 */
public class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLinkedList {
        int freq;
        Node head, tail;
        DLinkedList(int freq) {
            this.freq = freq;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            Node t = head.next;
            head.next = node;
            node.prev = head;
            node.next = t;
            t.prev = node;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        void delete(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node pop() {
            if (isEmpty()) {
                return null;
            }
            Node node = tail.prev;
            delete(node);
            return node;
        }
    }

    int capacity, size, minFreq;
    Map<Integer, Node> keyMap;
    Map<Integer, DLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    private int update(Node node) {
        int freq = node.freq;
        freqMap.get(freq).delete(node);
        node.freq++;
        if (!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new DLinkedList(node.freq));
        }
        freqMap.get(node.freq).add(node);
        while (freqMap.get(minFreq).isEmpty()) {
            minFreq++;
        }
        return node.value;
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        Node node = keyMap.get(key);
        return update(node);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            update(node);
            return;
        }
        if (size >= capacity) {
            Node toDel = freqMap.get(minFreq).pop();
            keyMap.remove(toDel.key);
            size--;
        }
        Node node = new Node(key, value);
        DLinkedList dll = freqMap.getOrDefault(node.freq, new DLinkedList(1));
        dll.add(node);
        keyMap.put(key, node);
        freqMap.put(1, dll);
        minFreq = 1;
        size++;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }
}
