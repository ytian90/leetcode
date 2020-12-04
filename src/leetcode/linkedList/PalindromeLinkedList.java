package leetcode.linkedList;
/**
 * 234. Palindrome Linked List
 * @author yutian
 * @since Aug 2, 2015
 */
public class PalindromeLinkedList {

	// Solution 2: Time ~O(N), Space ~O(1)
	public boolean isPalindrome2(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) slow = slow.next;
		slow = reverse(slow);
		while (slow != null && head.val == slow.val) {
			head = head.next;
			slow = slow.next;
		}
		return slow == null;
	}

	private ListNode reverse(ListNode curr) {
		ListNode prev = null;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public boolean isPalindromes(ListNode head) {
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		ListNode p = head;
		while (p != null) {
			a.append(p.val);
			b.insert(0, p.val);
			p = p.next;
		}
		return a.toString().equals(b.toString());
	}

	public static void main(String[] args) {
		ListNode n0 = new ListNode(1);
		ListNode n1 = new ListNode(2);
		n0.next = n1;
		System.out.println(isPalindrome(n0));

//		ListNode n2 = new ListNode(1);
//		ListNode n3 = new ListNode(2);
//		ListNode n4 = new ListNode(2);
//		n2.next = n3; n3.next = n4;
//		System.out.println(isPalindrome(n2));

		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(1);
		n2.next = n3; n3.next = n4; n4.next = n5;
		System.out.println(isPalindrome(n2));

	}

	// Time ~O(N), Space ~O(1)
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null; // disconnect

		// reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null; // end of the recreated list

		// compare two sublists now
		ListNode p = p1;
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;
			p = p.next;
			q = q.next;
		}

		return true;
	}


}
