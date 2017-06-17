package linkedList;
/**
 * Rotate List
 * @author yutian
 * @since Aug 19, 2015
 */
public class RotateList {

	// Solution 2: Form a circle
	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		// find the list size
		int size = 0;
		ListNode curr = dummy;
		while (curr.next != null) {
			curr = curr.next;
			size++;
		}
		// connect end to start to form a circle
		curr.next = head;
		// find the breaking point
		k = size - k % size;
		while (k > 0) {
			curr = curr.next;
			k--;
		}
		dummy.next = curr.next;
		curr.next = null;
		return dummy.next;
	}
	
	public static void main(String[] args) {
		RotateList t = new RotateList();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode p = t.rotateRight2(n1, 2);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	
	// Solution 1: Not Working Well when K > size of link list
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k <= 0)
			return head;
		ListNode prev = head, curr = head;
		while (curr.next != head || k > 0) {
			if (k > 0) {
				k--;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
			if (curr.next == null) curr.next = head;
		}
		ListNode dummy = prev.next;
		prev.next = null;
		return dummy;
	}
}
