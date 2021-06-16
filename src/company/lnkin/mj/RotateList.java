package company.lnkin.mj;

import leetcode.linkedList.ListNode;

/**
 * LC 61. Rotate List
 *
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Example 1:
 * rotate 1: 5-> 1-> 2-> 3-> 4
 * rotate 2: 4-> 5-> 1-> 2-> 3
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 * Example 2:
 *
 *
 * Input: head = [0,1,2], k = 4
 * Output: [2,0,1]
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int count = 0;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        int t = k % count;
        fast = head;
        for (int i = 0; i < t; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }


    /**
     * Reverse rotate list
     */

    public static ListNode rotateLeft(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        int count = 1;
        while (fast.next != null) {
            count++;
            fast = fast.next;
        }
        int t = k % count;
        for (int i = 0; i < t - 1; i++) {
            slow = slow.next;
        }
        fast.next = head;
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        n0.next = new ListNode(1);
        n0.next.next = new ListNode(2);
        n0.next.next.next = new ListNode(3);
        n0.next.next.next.next = new ListNode(4);
        System.out.println(rotateLeft(n0, 2).val);
    }
}
