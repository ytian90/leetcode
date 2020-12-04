package leetcode.linkedList;
/**
 * 148. Sort List
 * @author yutian
 * @since Aug 17, 2015
 */
public class SortList {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		// find the middle point (slow pointing to mid)
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// merge leetcode.sort two lists recursively
		ListNode left = head, right = slow.next;
		slow.next = null; // break into 2 lists
		left = sortList(left);
		right = sortList(right);
		return merge(left, right); // given the beginning nodes of two lists
//		return merge2(left, right);
	}

	// Solution 1 to merge
	private static ListNode merge(ListNode l, ListNode r) {
		if (l == null) return r;
		if (r == null) return l;
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (l != null && r != null) {
			if (l.val < r.val) {
				p.next = l;
				l = l.next;
			} else {
				p.next = r;
				r = r.next;
			}
			p = p.next;
		}
		if (l != null) p.next = l;
		if (r != null) p.next = r;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(2);
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(4);
		
		ListNode p = sortList(n0);
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();

		n0.next = n1;
		ListNode p2 = sortList(n0);
		while (p2 != null) {
			System.out.print(p2.val + " ");
			p2 = p2.next;
		}
		System.out.println();

		n1.next = n2; n2.next = n3;
		ListNode p3 = sortList(n0);
		while (p3 != null) {
			System.out.print(p3.val + " ");
			p3 = p3.next;
		}
		System.out.println();
		
	}
	
	// Solution 2 to merge
	private ListNode merge2(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		dummy.next = left;
		
		ListNode prev = dummy;
		while (left != null && right != null) {
			// always keep the smaller one to the leftmost only move the right
			// list when it's smaller
			if (left.val < right.val) {
				left = left.next;
			} else {
				// move the node (right list) between prev and the leftmost node (left list)
				ListNode nt = right.next;
				right.next = prev.next;
				prev.next = right;
				right = nt;
			}
			prev = prev.next;
		}
		if (right != null) prev.next = right;
		return dummy.next;
	}
}
