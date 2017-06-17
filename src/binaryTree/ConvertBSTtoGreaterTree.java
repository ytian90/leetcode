package binaryTree;
/**
 * 538. Convert BST to Greater Tree
 * @author ytian
 *
 */
public class ConvertBSTtoGreaterTree {
	
	static int sum = 0;
	
	public static TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
	
	/*
	 * Do a reverse in-order traversal to traverse the nodes of the tree
	 * in descending order.
	 */
	private static void helper(TreeNode node) {
		if (node == null) return;
		helper(node.right);
		node.val += sum;
		sum = node.val;
		helper(node.left);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(13);
		n1.left = n2; n1.right = n3;
		
		System.out.println(convertBST(n1).left.val);
	}

}
