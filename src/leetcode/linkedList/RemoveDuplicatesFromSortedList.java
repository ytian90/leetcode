package leetcode.linkedList;
/**
 * 83. Remove Duplicates from Sorted List
 * @author yutian
 * @since Aug 11, 2015
 */
public class RemoveDuplicatesFromSortedList {
	
	// Time ~O(N), Space ~O(1)
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head, fast = head.next;
		while (fast != null) {
			if (slow.val == fast.val) {
				slow.next = fast.next;
			} else {
				slow = fast;
			}
			fast = fast.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		n0.next = n1;
		n1.next = n2;
		print(deleteDuplicates(n0));
		
		System.out.println();
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(2);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(3);
		n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		print(deleteDuplicates(n3));
		
	}

	public static void print(ListNode n) {
		ListNode p = n;
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}
