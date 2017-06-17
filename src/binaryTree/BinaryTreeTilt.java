package binaryTree;
/**
 * 563. Binary Tree Tilt
 * @author ytian
 *
 */
public class BinaryTreeTilt {

	static int res = 0;
	
	public static int findTilt(TreeNode root) {
        postOrder(root);
        return res;
    }
	
	private static int postOrder(TreeNode node) {
		if (node == null) return 0;
		int left = postOrder(node.left);
		int right = postOrder(node.right);
		res += Math.abs(left - right);
		return left + right + node.val;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		
		n0.left = n1; n0.right = n2;
		System.out.println(findTilt(n0));
	}

}
