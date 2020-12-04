package leetcode.linkedList;
/**
 * 92. Reverse Linked List II
 * @author yutian
 * @since Aug 18, 2015
 */
public class ReverseLinkedList2 {
	// Solution 1: for loop Time ~O(N)
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = dummy;
		for (int i = 0; i < m - 1; i++) {
			prev = prev.next;
		}
		curr = prev.next;
		for (int i = 0; i < n - m; i++) {
			ListNode nt = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nt;
		}
		return dummy.next;
	}
	
	// Solution 2: while loop
	public ListNode reverseBetween2(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = dummy.next;
		int pos = 1;
		while (pos < m && curr != null) {
			prev = curr;
			curr = curr.next;
			pos++;
		}
		while (pos < n && curr != null) {
			ListNode nt = curr.next.next;
			curr.next.next = prev.next;
			prev.next = curr.next;
			curr.next = nt;
			pos++;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ListNode result = reverseBetween(n0, 2, 4);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		
	}
	
}
