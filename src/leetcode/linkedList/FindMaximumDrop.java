package leetcode.linkedList;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=169793&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Feb 9, 2016
 */
public class FindMaximumDrop {
	
	public int maxDrop(ListNode head) {
		if (head == null || head.next == null) return -1;
		ListNode prev = head, curr = head.next;
		int max = Integer.MIN_VALUE;
		while (curr != null && curr.next != null) {
			if (curr.next.val == curr.val) {
				curr = curr.next;
			} else if (curr.val > curr.next.val) {
				if (prev != head) prev = curr;
				while (curr.next != null && curr.val > curr.next.val) {
					curr = curr.next;
				}
				max = Math.max(max, prev.val - curr.val);
				if (curr.next == null) break;
				else {
					prev = curr.next;
					curr = prev;
				}
			} else {
				curr = curr.next;
				prev = prev.next;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		FindMaximumDrop t = new FindMaximumDrop();
		ListNode n0 = new ListNode(10);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(8);
		ListNode n5 = new ListNode(8);
		n0.next = n1; n1.next = n2; n2.next = n3;
		n3.next = n4; n4.next = n5;
		System.out.println(t.maxDrop(n0));
		
	}

}
