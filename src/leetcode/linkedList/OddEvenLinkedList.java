package leetcode.linkedList;
/**
 * 328. Odd Even Linked List
 * @author yutian
 * @since Jan 16, 2016
 */
public class OddEvenLinkedList {
	
	// time ~O(N), space ~O(1)
	public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
        	return head;
        }
        ListNode odd = head, even = head.next, p = odd, q = even;
        while (p.next != null && q.next != null) {
        	p.next = q.next;
        	p = p.next;
        	q.next = p.next;
        	q = q.next;
        }
        p.next = even;
        return odd;
    }

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode result = oddEvenList(n1);
		ListNode p = result;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
	}

}
