package linkedList;
/**
 * Partition List
 * @author yutian
 * @since Aug 17, 2015
 */
public class PartitionList {
	
	// Solution 2: pick out larger nodes and append to the end
	public static ListNode partition2(ListNode head, int x) {
		if (head == null || head.next == null) return head;
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode p = d1, q = d2;
        p.next = head;
        while (p.next != null) {
            if (p.next.val < x) {
                p = p.next;
            } else {
                q.next = p.next;
                p.next = p.next.next;
                q = q.next;
            }
        }
        p.next = d2.next;
        q.next = null;
        return d1.next;
	}
	
	// Solution 1: move the smaller nodes into the front
	public static ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
			
		// find the last continuous node that < x, same as find first node > x
		ListNode last = dummy;
		while (last.next != null && last.next.val < x) last = last.next;
		
		// find and move the next node that < x
		ListNode curr = last;
		while (curr.next != null) {
			if (curr.next.val < x) {
				ListNode nt = curr.next.next;
				curr.next.next = last.next;
				last.next = curr.next;
				curr.next = nt;
				last = last.next;
			} else {
				curr = curr.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(2);
		
		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;
		ListNode t = partition2(n0, 3);
		ListNode n = t;
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}
		
	}
}
