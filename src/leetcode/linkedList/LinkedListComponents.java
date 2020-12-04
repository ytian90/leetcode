package leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. Linked List Components
 */
public class LinkedListComponents {
    public static int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) set.add(i);
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val)))
                res++;
            head = head.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n0.next = n1; n1.next = n2; n2.next = n3;
        System.out.println(numComponents(n0, new int[]{0, 1, 3}));

        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(2);
        n4.next = n5; n5.next = n6;
        System.out.println(numComponents(n4, new int[]{1, 0}));
    }
}
