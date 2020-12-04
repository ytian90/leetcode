package leetcode.binaryTree;
/**
 * Print BST keys in the given range
 * http://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/
 * @author yutian
 * @since Feb 29, 2016
 */
public class PrintBSTKeysInTheGivenRange {
	
	static TreeNode root;
	
	public void print(TreeNode node, int min, int max) {
		if (node == null) return;
		if (node.val > min) {
			print(node.left, min, max);
		}
		if (node.val >= min && node.val <= max) {
			System.out.println(node.val + " ");
		}
		if (node.val < max) {
			print(node.right, min, max);
		}
	}

	public static void main(String[] args) {
		PrintBSTKeysInTheGivenRange tree = new PrintBSTKeysInTheGivenRange();
        int k1 = 10, k2 = 25;
        tree.root = new TreeNode(20);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(12);
 
        tree.print(root, k1, k2);
	}

}
