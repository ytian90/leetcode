package linkedList;
/**
 * Linked List Cycle
 * @author yutian
 * @since Aug 24, 2015
 */
public class LinkedListCycle {
	// Time O(N) Space O(1)
	public static boolean hasCycle(ListNode head) {
		if (head == null) return false;
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l2;
		
		System.out.println(hasCycle(l0));
	}
}
