package leetcode.linkedList;
/**
 * 147. Insertion Sort List
 * @author yutian
 * @since Aug 17, 2015
 */
public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		while (curr != null && curr.next != null) {
			prev = dummy;
			while (prev != curr) {
				if (prev.next.val > curr.next.val) { // move curr.next after prev.next
					ListNode t = curr.next.next;
					curr.next.next = prev.next;
					prev.next = curr.next;
					curr.next = t;
					break; // remove cause runtime error
				} else {
					prev = prev.next;
				}
			}
			if (prev == curr) {
				curr = curr.next; // move curr forward if curr.next was not found
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(3);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(1);
		n0.next = n1; n1.next = n2;
		n0 = insertionSortList(n0);
		ListNode t = n0;
		while (t != null) {
			System.out.print(t.val + " ");
			t = t.next;
		}
	}
	
}
