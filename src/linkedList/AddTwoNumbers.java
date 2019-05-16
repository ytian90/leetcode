package linkedList;

/**
 * 2. Add Two Numbers
 * @author yutian
 * @since Jul 26, 2015
 */
public class AddTwoNumbers {
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int digit = x + y + carry;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode p = new ListNode(2);
		p.next = new ListNode(4);
		p.next.next = new ListNode(3);
		
		ListNode q = new ListNode(5);
		q.next = new ListNode(6);
		q.next.next = new ListNode(4);
		q.next.next.next = new ListNode(1);
		
		ListNode ans = addTwoNumbers(p, q);
		ListNode a = ans;
		while (a != null) {
			System.out.println(a.val);
			a = a.next;
		}
	}
}
