package leetcode.binaryTree;
/**
 * Maximum Path Sum in a Binary Tree
 * http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
 * @author yutian
 * @since Feb 11, 2016
 */
public class MaximumPathSumInABinaryTree {
	
	TreeNode root;
	
	class Res {
		public int val;
	}
	
	public int findMaxUtil(TreeNode TreeNode, Res res) {
		// Base Case
        if (TreeNode == null)
            return 0;
 
        // l and r store maximum path sum going through left and
        // right child of root respectively
        int l = findMaxUtil(TreeNode.left, res);
        int r = findMaxUtil(TreeNode.right, res);
 
        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(Math.max(l, r) + TreeNode.val,
                                  TreeNode.val);
 
 
        // Max Top represents the sum when the TreeNode under
        // consideration is the root of the max sum path and no
        // ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + TreeNode.val);
 
        // Store the Maximum Result.
        res.val = Math.max(res.val, max_top);
 
        return max_single;
	}
	
	public int findMaxSum(TreeNode TreeNode) {
		// Initialize result
        // int res2 = Integer.MIN_VALUE;
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
 
        // Compute and return result
        findMaxUtil(TreeNode, res);
        return res.val;
	}

	public static void main(String[] args) {
		MaximumPathSumInABinaryTree tree = new MaximumPathSumInABinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(10);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.right = new TreeNode(1);
        tree.root.right.right = new TreeNode(-25);
        tree.root.right.right.left = new TreeNode(3);
        tree.root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                            tree.findMaxSum(tree.root));
	}

}
