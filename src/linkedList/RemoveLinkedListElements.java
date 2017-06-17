package linkedList;
/**
 * Remove Linked List Elements
 * @author yutian
 * @since Aug 4, 2015
 */
public class RemoveLinkedListElements {
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		n0.next = n1; n1.next = n2;
		print(removeElements(n0, 1));
	}
	
	public static void print(ListNode n) {
		while (n != null) {
			System.out.println(n.val);
			n = n.next;
		}
	}
	
	// Solution 1
	public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }
	
	// Solution 2
	public static ListNode removeElements2(ListNode head, int val) {
		if (head == null) return head;
		ListNode p = head;
		while (p.next != null) {
			if (p.next.val == val) p.next = p.next.next;
			else p = p.next;
		}
		return head.val == val ? head.next : head;
	}
}
