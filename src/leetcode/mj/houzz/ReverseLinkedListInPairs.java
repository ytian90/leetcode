package leetcode.mj.houzz;

import leetcode.linkedList.ListNode;

/**
 * reverse LinkedList in pair，follow up 是reverse in K-pair
 * https://instant.1point3acres.com/thread/415835
 * leetcode 25
 */
public class ReverseLinkedListInPairs {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        int pos = 1;
        while (curr != null) {
            if (pos == k) {
                pos = 0;
                prev = reverse(prev, curr);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
            pos++;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode prev, ListNode end) {
        ListNode curr = prev.next;
        while (prev.next != end) {
            ListNode t = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = t;
        }
        return curr;
    }
}
