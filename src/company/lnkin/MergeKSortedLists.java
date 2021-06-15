package company.lnkin;

import leetcode.linkedList.ListNode;

/**
 * LC 23. Merge K Sorted Lists
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int lo, int hi) {
        if (lo > hi) return null;
        if (lo == hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l = partition(lists, lo, mid);
        ListNode r = partition(lists, mid + 1, hi);
        return merge(l, r);
    }

    private ListNode merge(ListNode p, ListNode q) {
        ListNode dummy = new ListNode(0), k = dummy;
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
}
