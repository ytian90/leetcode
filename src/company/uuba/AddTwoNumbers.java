package company.uuba;

import leetcode.linkedList.ListNode;

/**
 * LC 2. Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2;
        ListNode dummy = new ListNode(0);
        ListNode c = dummy;
        int sum = 0;
        while (p != null || q != null) {
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            c.next = new ListNode(sum % 10);
            sum /= 10;
            c = c.next;
        }
        if (sum > 0) {
            c.next = new ListNode(1);
        }
        return dummy.next;
    }
    /**
     * Time: O(N), N the the maximum length between l1 and l2
     * Space: O(N)
     */
}
