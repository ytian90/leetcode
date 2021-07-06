package company.uuba;

import leetcode.linkedList.ListNode;

/**
 * LC 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), k = dummy, p = l1, q = l2;
        while (p != null && q != null) {
            if (p.val < q.val) {
                k.next = p;
                p = p.next;
            } else {
                k.next = q;
                q = q.next;
            }
            k = k.next;
        }
        if (p != null) k.next = p;
        if (q != null) k.next = q;
        return dummy.next;
    }
    /**
     * Time: O(N), N is the total number of nodes in l1 and l2
     * Space: O(1)
     */
}
