package linkedList;
/**
 * 109. Convert Sorted List to Binary Search Tree
 * @author yutian
 * @since Aug 21, 2015
 */
public class ConvertSortedListToBinarySearchTree {
	// Bottom-up: O(N)
	private static ListNode list;
	
	public static TreeNode sortedListToBST(ListNode head) {
		int n = 0;
		ListNode p = head;
		while (p != null) {
			n++;
			p = p.next;
		}
		list = head;
		return sortedListToBST(0, n - 1);
	}

	private static TreeNode sortedListToBST(int start, int end) {
		if (start > end) return null;
		int mid = (start + end) / 2;
		TreeNode leftChild = sortedListToBST(start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(mid + 1, end);
		return parent;
	}

	public static void main(String[] args) {
//		ListNode n0 = new ListNode(1);
//		ListNode n1 = new ListNode(2);
//		n0.next = n1;
//		TreeNode n2 = sortedListToBST(n0);
//		printTree(n2);
		
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n3.next = n4; n4.next = n5;
		TreeNode n6 = sortedListToBST(n3);
		printTree(n6);
	}
	
	private static void printTree(TreeNode n) {
		if (n == null) return;
		System.out.print(n.val + " ");
		printTree(n.left);
		printTree(n.right);
	}
	
}
