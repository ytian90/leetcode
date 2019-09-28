package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * @author yutian
 * @since Jul 26, 2015
 */
public class CopyListWithRandomPointer {

	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node curr = head;
		while (curr != null) {
			if (!map.containsKey(curr)) {
				map.put(curr, new Node(curr.val));
			}
			curr = curr.next;
		}
		curr = head;
		while (curr != null) {
			map.get(curr).next = map.get(curr.next);
			map.get(curr).random = map.get(curr.random);
			curr = curr.next;
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
	public Node copyRandomList2(Node head) {
		if (head == null) return null;
		Node p = head;
		while (p != null) {
			Node next = p.next;
			Node copy = new Node(p.val);
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
		Node headCopy = p.next;
		while (p != null) {
			Node copy = p.next;
			p.next = copy.next;
			p = p.next;
			copy.next = (p != null) ? p.next: null;
		}
		return headCopy;
	}

	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _next,Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};
}
