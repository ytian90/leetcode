package linkedList;
/**
 * Intersection of Two Linked Lists
 * @author yutian
 * @since Aug 3, 2015
 */
public class IntersectionOfTwoLinkedLists {
	
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
