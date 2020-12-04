package leetcode.linkedList;
/**
 * 25. Reverse Nodes in k-Group
 * @author yutian
 * @since Aug 18, 2015
 */
public class ReverseNodesInK_Group {
	// Solution 1 Time ~ O(2N), Space ~ O(1) 
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = dummy.next;
		int pos = 1;
		while (curr != null) {
			if (pos == k) {
				pos = 0;
				prev = reverse(prev, curr);
				curr = prev.next;
			} else {
				curr = curr.next;
			}
			pos++;
		}
		return dummy.next;
	}

	private static ListNode reverse(ListNode prev, ListNode end) {
		ListNode curr = prev.next;
        while (prev.next != end) {
            ListNode t = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = t;
        }
        return curr;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;
		ListNode p = reverseKGroup(n0, 2);
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}
	
	// Solution 2 Time ~ O(2N), Space ~ O(1) 
	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		if (head == null || k == 0) return dummy.next;
		int len = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			len++;
		}
		ListNode prev = dummy,  curr = dummy.next;
		for (int i = 0; i < len / k; i++) {
			for (int j = 0; j < k - 1; j++) {
				ListNode nt = curr.next.next;
				curr.next.next = prev.next;
				prev.next = curr.next;
				curr.next = nt;
			}
			prev = curr;
			curr = curr.next;
		}
		return dummy.next;
	}
}
