package leetcode.linkedList;

/**
 * Merge Two Sorted Lists
 * @author yutian
 * @since Jul 26, 2015
 */
public class MergeTwoSortedLists {
	// iterative Time ~ O(Na + Nb), Space ~ O(1)
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode c = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				c.next = l1;
				l1 = l1.next;
			} else {
				c.next = l2;
				l2 = l2.next;
			}
			c = c.next;
		}
		if (l1 != null) c.next = l1;
		if (l2 != null) c.next = l2;
		return dummy.next;
	}
	
	// recursive
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		if (l1.val <= l2.val) {
			l1.next = mergeTwoLists2(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l0 = new ListNode(1);
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(4);
		
		l0.next = l1; l1.next = l2;
		l3.next = l4;
		ListNode result = mergeTwoLists(l0, l3);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

}
