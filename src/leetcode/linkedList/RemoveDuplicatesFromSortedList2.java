package leetcode.linkedList;
/**
 * Remove Duplicates from Sorted List II
 * @author yutian
 * @since Aug 20, 2015
 */
public class RemoveDuplicatesFromSortedList2 {

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		while (curr != null && curr.next != null) {
			if (curr.val != curr.next.val) { // no duplicates, move towards next
				prev = curr;
			} else {
				while (curr.next != null && curr.val == curr.next.val) curr = curr.next;
				prev.next = curr.next;
			}
			curr = curr.next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6;
		print(n0);
		print(deleteDuplicates(n0));
		
		ListNode n7 = new ListNode(1);
		ListNode n8 = new ListNode(1);
		ListNode n9 = new ListNode(1);
		ListNode n10 = new ListNode(2);
		ListNode n11 = new ListNode(3);
		n7.next = n8; n8.next = n9; n9.next = n10; n10.next = n11;
		print(n7);
		print(deleteDuplicates(n7));
		
		
		ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(1);
		l0.next = l1;
		print(l0);
		print(deleteDuplicates(l0));
		
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		l2.next = l3;
		print(l2);
		print(deleteDuplicates(l2));
	}
	
	public static void print(ListNode n) {
		ListNode p = n;
		while (p != null) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		System.out.println();
	}
}
