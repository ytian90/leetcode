package binaryTree;

/**
 * Convert Sorted List to Balanced Binary Search Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class ConvertSortedListToBalancedBinarySearchTree {
	private ListNode list;
	private TreeNode sortedListToBST(int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode leftChild = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}
	public TreeNode sortedListToBST(ListNode head) {
		int n = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			n++;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}
}
