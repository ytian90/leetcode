package binaryTree;

import util.BTreePrinter;

/**
 * 109. Convert Sorted List to Balanced Binary Search Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class ConvertSortedListToBalancedBinarySearchTree {

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		return helper(head, null);
	}

	public static TreeNode helper(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == tail) return null;

		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode node = new TreeNode(slow.val);
		node.left = helper(head, slow);
		node.right = helper(slow.next, tail);
		return node;
	}

	public static void main(String[] args) {
		ListNode n0 = new ListNode(-10);
		ListNode n1 = new ListNode(-3);
		ListNode n2 = new ListNode(0);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(9);

		n0.next = n1; n1.next = n2; n2.next = n3; n3.next = n4;

		BTreePrinter.printTreeNode(sortedListToBST(n0));

	}

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

	public TreeNode sortedListToBST3(ListNode head) {
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
