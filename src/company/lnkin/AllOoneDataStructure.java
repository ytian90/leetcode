package company.lnkin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 432. All O`one Data Structure
 *
 * Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.
 *
 * Implement the AllOne class:
 *
 * AllOne() Initializes the object of the data structure.
 * inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
 * dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
 * getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
 * getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
 *
 *
 * Example 1:
 *
 * Input
 * ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
 * [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
 * Output
 * [null, null, null, "hello", "hello", null, "hello", "leet"]
 *
 * Explanation
 * AllOne allOne = new AllOne();
 * allOne.inc("hello");
 * allOne.inc("hello");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "hello"
 * allOne.inc("leet");
 * allOne.getMaxKey(); // return "hello"
 * allOne.getMinKey(); // return "leet"
 *
 */
public class AllOoneDataStructure {
    private Node head, tail;
    Map<String, Node> map;

    /** Initialize your data structure here. */
    public AllOoneDataStructure() {
        this.map = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);
            if (node.next == null) {
                Node next = new Node(freq + 1);
                node.next = next;
                next.prev = node;
                next.keys.add(key);
                map.put(key, next);
                tail = next;
            } else {
                Node next = node.next;
                if (next.freq - freq == 1) {
                    next.keys.add(key);
                    map.put(key, next);
                } else {
                    Node mid = new Node(freq + 1);
                    mid.keys.add(key);
                    node.next = mid;
                    mid.prev = node;
                    mid.next = next;
                    next.prev = mid;
                    map.put(key, mid);
                }
            }
            if (node.keys.isEmpty()) {
                removeNode(node);
            }
        } else {
            if (head == null) {
                head = new Node(1);
                head.keys.add(key);
                tail = head;
            } else {
                if (head.freq == 1) {
                    head.keys.add(key);
                } else {
                    Node prev = new Node(1);
                    prev.keys.add(key);
                    prev.next = head;
                    head.prev = prev;
                    head = prev;
                }
            }
            map.put(key, head);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node node = map.get(key);
        int freq = node.freq;
        node.keys.remove(key);
        if (freq == 1) {
            map.remove(key);
        } else if (node == head) {
            Node prev = new Node(freq - 1);
            prev.keys.add(key);
            prev.next = head;
            head.prev = prev;
            head = prev;
            map.put(key, head);
        } else {
            Node prev = node.prev;
            if (freq - prev.freq == 1) {
                prev.keys.add(key);
                map.put(key, prev);
            } else {
                Node mid = new Node(freq - 1);
                prev.next = mid;
                mid.prev = prev;
                mid.next = node;
                node.prev = mid;
                mid.keys.add(key);
                map.put(key, mid);
            }
        }
        if (node.keys.isEmpty()) {
            removeNode(node);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head == null ? "" : tail.keys.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head == null ? "" : head.keys.iterator().next();
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (node == tail) {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        AllOoneDataStructure obj = new AllOoneDataStructure();
        obj.inc("hello");
        obj.inc("hello");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
        obj.inc("leetcode");
        System.out.println(obj.getMaxKey());
        System.out.println(obj.getMinKey());
    }

    class Node {
        int freq;
        Node prev, next;
        Set<String> keys;

        public Node(int freq) {
            this.freq = freq;
            this.keys = new HashSet<>();
        }
    }
}
