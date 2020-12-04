package leetcode.linkedList;

/**
 * 24. Swap Nodes in Pairs
 * @author yutian
 * @since Jul 26, 2015
 */
public class SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = head;
		ListNode prev = dummy;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		n0.next = n1; n1.next = n2; n2.next = n3;
		
		ListNode t = swapPairs(n0);
		while (t != null) {
			System.out.print(t.val + " ");
			t = t.next;
		}
	}
}
