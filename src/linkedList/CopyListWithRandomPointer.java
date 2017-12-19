package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * @author yutian
 * @since Jul 26, 2015
 */
public class CopyListWithRandomPointer {
	
	// Solution 0 Recursion
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		// loop 1 copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
			node = node.next;
		}
		
		// loop 2 assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}
		
		return map.get(head);
	}
	
	// Solution 1 Time O(n) Space O(n)
	public RandomListNode copyRandomList1(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode p = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode q = dummy;
		while (p != null) {
			q.next = new RandomListNode(p.label);
			map.put(p, q.next);
			p = p.next;
			q = q.next;
		}
		p = head;
		q = dummy;
		while (p != null) {
			q.next.random = map.get(p.random);
			p = p.next;
			q = q.next;
		}
		return dummy.next;
	}
	
	// Solution 2 Time O(n) Space O(1)
	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null) return null;
		RandomListNode p = head;
		while (p != null) {
			RandomListNode next = p.next;
			RandomListNode copy = new RandomListNode(p.label);
			p.next = copy;
			copy.next = next;
			p = next;
		}
		p = head;
		while (p != null) {
			p.next.random = (p.random != null) ? p.random.next : null;
			p = p.next.next;
		}
		p = head;
		RandomListNode headCopy = p.next;
		while (p != null) {
			RandomListNode copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next: null;
		}
		return headCopy;
	}
	
	
}
