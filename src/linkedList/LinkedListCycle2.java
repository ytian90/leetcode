package linkedList;
/**
 * Linked List Cycle II
 * @author yutian
 * @since Aug 24, 2015
 */
public class  LinkedListCycle2 {
	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode slow = head, fast = head;
		// fast.next != null && fast.next.next != null also works
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode slow2 = head;
				while (slow2 != slow) {
					slow2 = slow2.next;
					slow = slow.next;
				}
				return slow2;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		
		ListNode l6 = new ListNode(0);
		
		l0.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l2;
		
		l6.next = l6; // only one node, tail connects to node index 0 (itself)
		
		System.out.println(detectCycle(l0).val);
		System.out.println(detectCycle(l6).val);
	}
}
