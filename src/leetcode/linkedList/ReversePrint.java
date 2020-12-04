package leetcode.linkedList;
/**
 * Print out linked list reversely
 * @author yutian
 * @since Sep 21, 2015
 * 
 * Suppose you are given a linked list
 * 4->3->1->6->7
 * Write a routine to print this list in reverse
 * Restrictions: You cannot use a data structure to duplicate all the information
 * and you cannot modify the original list
 * 
 */
public class ReversePrint {
	public void printReverse(ListNode head) {
		if (head == null) return;
		printReverse(head.next);
		System.out.printf("%d ", head.val);
	}
}
