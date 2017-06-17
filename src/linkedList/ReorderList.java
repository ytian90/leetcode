package linkedList;
/**
 * Reorder List
 * @author yutian
 * @since Aug 24, 2015
 */
public class ReorderList {
	// Solution 1
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) return;
		
		// find the middle point
		ListNode prev = null, slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// reverse the second half and break two halves
		slow = reverse(prev);// return the beginning node of the second half
		prev.next = null;
		
		// merge two halves
		ListNode curr = head;
		while (curr != null && slow != null && curr != slow) {
			ListNode nt = curr.next;
			curr.next = slow;
			curr = curr.next;
			slow = nt;
		}
	}

	private ListNode reverse(ListNode prev) {
		if (prev == null) return null;
		ListNode curr = prev.next;
		while (curr != null && curr.next != null) {
			ListNode nt = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nt;
		}
		return prev.next;
	}
}
