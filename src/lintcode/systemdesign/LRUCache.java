package lintcode.systemdesign;

import java.util.*;

/**
 * 134. LRU Cache
 */
public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
            this(0, 0);
        }
    }

    int capacity, count;
    Map<Integer, Node> map;
    Node head, tail;
    /*
     * @param capacity: An integer
     */public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        update(node);
        return node.value;
    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    private void remove(Node node) {
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    private void add(Node node) {
        Node after = head.next;
        head.next = node;
        node.next = after;
        after.prev = node;
        node.prev = head;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            add(node);
            map.put(key, node);
            count++;
        } else {
            Node node = map.get(key);
            node.value = value;
            update(node);
        }
        if (count > capacity) {
            Node delNode = tail.prev;
            remove(delNode);
            map.remove(delNode.key);
            count--;
        }
    }
}
