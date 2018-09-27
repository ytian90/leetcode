package linkedList;
/**
 * 160. Intersection of Two Linked Lists
 * @author yutian
 * @since Aug 3, 2015
 */
public class IntersectionOfTwoLinkedLists {

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// boundary check
		if (headA == null || headB == null) return null;
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);

		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;
		n5.next = n6; n6.next = n7; n7.next = n2;
		System.out.println(getIntersectionNode(n0, n5).val);
	}
	
	// Solution 1 Time ~O(n), Space ~O(1)
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		
		int len1 = getLen(headA);
		int len2 = getLen(headB);
		int count = Math.abs(len1 - len2);
		
		if (len1 > len2) {
			while (count > 0) {
				headA = headA.next;
				count--;
			}
		} else {
			while (count > 0) {
				headB = headB.next;
				count--;
			}
		}
		
		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}

	private int getLen(ListNode head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
	
	// Solution 2 
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;

        ListNode pA = headA;
        ListNode pB = headB;
        
        ListNode tailA = null;
        ListNode tailB = null;
        
        while (true) {
        	if (pA == null) {
        		pA = headB;
        	}
        	
        	if (pB == null) {
        		pB = headA;
        	}
        	
        	if (pA.next == null) {
        		tailA = pA;
        	}
        	
        	if (pB.next == null) {
        		tailB = pB;
        	}
        	
        	// The two links have different tails. So just return null;
        	if (tailA != null && tailB != null && tailA != tailB) {
        		return null;
        	}
        	
        	if (pA == pB) {
        		return pA;
        	}
        		
        	pA = pA.next;
        	pB = pB.next;
        }
    }
}
