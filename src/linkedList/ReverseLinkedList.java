package linkedList;
/**
 * 206. Reverse Linked List
 * @author yutian
 * @since Aug 3, 2015
 */
public class ReverseLinkedList {
	// Time ~O(N), Space ~O(1)
	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode p = head, q = head.next;
        while (q != null) {
            ListNode t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        head.next = null;
        return p;
    }
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		
		ListNode result = reverseList(n0);
		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		
	}
}
