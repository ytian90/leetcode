package linkedList;
/**
 * 369. Plus One Linked List
 * @author yutian
 * @since Jul 2, 2016
 */
public class PlusOneLinkedList {
	
	// Method 1 Recursion Time O(N)
	public static ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.val == 0 ? head : dummy;
    }
	
	private static int helper(ListNode node) {
		if (node == null) return 1;
		node.val += helper(node.next);
		if (node.val <= 9) return 0;
		node.val %= 10;
		return 1;
	}
	
	// Method 2 Iteration 2 pointers Time O(N)
	public static ListNode plusOne2(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;
		while (j.next != null) {
			j = j.next;
			if (j.val != 9) {
				i = j;
			}
		}
		if (j.val != 9) {
			j.val++;
		} else {
			i.val++;
			i = i.next;
			while (i != null) {
				i.val = 0;
				i = i.next;
			}
		}
		return dummy.val == 0 ? dummy.next : dummy;
	}

	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		n0.next = n1; n1.next = n2;
		ListNode res = plusOne(n0);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
}
