package reservoirSampling;

import java.util.Random;

/**
 * 382. Linked List Random Node
 * 
 * @author yutian
 * @since Aug 31, 2016
 */
public class LinkedListRandomNode {

	private ListNode head;
	private Random random;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
		this.random = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode res = null;
		ListNode curr = head;

		for (int i = 1; curr != null; i++) {
			if (random.nextInt(i) == 0) {
				res = curr;
			}
			curr = curr.next;
		}

		return res.val;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		LinkedListRandomNode t = new LinkedListRandomNode(head);
		int c1 = 0, c2 = 0, c3 = 0;
		for (int i = 0; i < 10000; i++) {
			int c = t.getRandom();
			if (c == 1) {
				c1++;
			} else if (c == 2) {
				c2++;
			} else {
				c3++;
			}
		}
		System.out.println("c1 = " + c1 + " c2 = " + c2 + " c3 = " + c3);
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
