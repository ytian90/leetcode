package binaryTree;
/**
 * 108. Convert Sorted Array to Balanced Binary Search Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class ConvertSortedArrayToBalancedBinarySearchTree {
	
	public static TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num, 0, num.length - 1);
	}

	// Time ~O(N), Space ~O(N)
	private static TreeNode sortedArrayToBST(int[] a, int start, int end) {
		if (start > end) return null;
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(a[mid]);
		node.left = sortedArrayToBST(a, start, mid - 1);
		node.right = sortedArrayToBST(a, mid + 1, end);
		return node;
	}
	
	public static void main(String[] args) {
		int[] t1 = new int[]{0};
		int[] t2 = new int[]{1, 2};
		int[] t3 = new int[]{2, 3, 4};
		TreeNode r1 = sortedArrayToBST(t1);
		TreeNode r2 = sortedArrayToBST(t2);
		TreeNode r3 = sortedArrayToBST(t3);
		printTree(r1);
		System.out.println();
		printTree(r2);
		System.out.println();
		printTree(r3);
	}
	
	private static void printTree(TreeNode n) {
		if (n == null) return;
		System.out.print(n.val + " ");
		printTree(n.left);
		printTree(n.right);
	}
}
