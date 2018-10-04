package linkedList;

/**
 * 725. Split Linked List in Parts
 */
public class SplitLinkedListInParts {

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode n = root; n != null; n = n.next)
            len++;
        int n = len / k, r = len % k;
        ListNode curr = root, prev = null;
        for (int i = 0; curr != null && i < k; i++, r--) {
            res[i] = curr;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        n0.next = new ListNode(2);
        n0.next.next = new ListNode(3);
        for (ListNode n : splitListToParts(n0, 5))
            System.out.println(n != null ? n.val: "empty");
    }
}
