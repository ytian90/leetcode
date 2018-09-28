package linkedList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 */
public class AddTwoNumbers2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode p = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            p.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = p;
            p = head;
            sum /= 10;
        }
        return p.val == 0 ? p.next : p;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(7);
        n0.next = new ListNode(2);
        n0.next.next = new ListNode(4);
        n0.next.next.next = new ListNode(3);

        ListNode n1 = new ListNode(5);
        n1.next = new ListNode(6);
        n1.next.next = new ListNode(4);

        ListNode n2 = addTwoNumbers(n0, n1);
        while (n2 != null) {
            System.out.print(n2.val + " ");
            n2 = n2.next;
        }
    }
}
