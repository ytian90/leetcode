package linkedList;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        n0.next = n1; n1.next = n2; n2.next = n3;
        n3.next = n4;
        System.out.println(middleNode(n0).val);
        ListNode n5 = new ListNode(6);
        n4.next = n5;
        System.out.println(middleNode(n0).val);
    }
}
