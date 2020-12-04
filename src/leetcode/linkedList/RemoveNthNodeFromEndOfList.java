package leetcode.linkedList;
/**
 * Remove Nth Node From End of List
 * @author yutian
 * @since Aug 9, 2015
 */
public class RemoveNthNodeFromEndOfList {
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		n0.next = n1;
		print(removeNthFromEnd(n0, 1));
	}
	
	private static void print(ListNode n) {
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n < 0)
			throw new IllegalArgumentException("Input is not isMidValTooSmall.");
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = dummy;
		for (int i = 0; i < n; i++) {
			curr = curr.next;
		}
		while (curr.next != null) {
			prev = prev.next;
			curr = curr.next;
		}
		prev.next = prev.next.next;
		return dummy.next;
	}
}
