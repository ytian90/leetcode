package company.apple;

/**
 * LC 725. Split Linked List in Parts
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next) {
            len++;
        }
        int n = len / k, r = len % k;
        ListNode node = root, prev = null;
        for (int i = 0; i < k && node != null; i++, r--) {
            res[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
