package design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * @author yutian
 * @since Oct 25, 2015
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key 
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently 
 * used item before inserting a new item.
 * 
 */
public class LRUCache {

	class Node {
		int key, value;
		Node prev, next;
		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Map<Integer, Node> map;
	private Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
		head = null;
		tail = null;
	}

	public int get(int key) {
		if (!map.containsKey(key)) return -1;
		else {
			moveToEnd(map.get(key));
			return map.get(key).value;
		}
	}

	public void put(int key, int value) {
		if (!map.containsKey(key)) { // if the node doesn't exist, add a new node to end
			// remove LRU (first node) if it reaches capacity
			if (map.size() == capacity) {
				map.remove(head.key);
				remove(head);
			}
			// add a new node at the end
			Node node = new Node(key, value);
			map.put(key, node);
			addToEnd(node);
		} else { // if the node exists, revise it and move to end
			map.get(key).value = value;
			moveToEnd(map.get(key));
		}
	}

	void addToEnd(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}

	void remove(Node node) {
		if (node == head) {
			head = head.next;
			if (head != null) head.prev = null;
		} else if (node == tail) {
			tail = tail.prev;
			if (tail != null) tail.next = null;
		} else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
	}

	void moveToEnd(Node node) {
		if (node == tail) return;
		remove(node);
		addToEnd(node);
	}

	public static void main(String[] args) {
		LRUCache obj = new LRUCache(2);
		obj.put(1, 1);
		obj.put(2, 2);
		System.out.println(obj.get(1));
		obj.put(3, 3);
		System.out.println(obj.get(2));
		obj.put(4, 4);
		System.out.println(obj.get(1));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
	}

}
