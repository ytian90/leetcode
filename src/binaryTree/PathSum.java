package binaryTree;

import java.util.Stack;

/**
 * 112. Path Sum
 * @author yutian
 * @since Aug 9, 2015
 */
public class PathSum {
	// Solution 1 Recursion Time ~O(N) Space ~O(logN)
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.left == null && root.right == null)
			return root.val == sum;
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
	
	// Solution 2 Stack BFS Time ~O(N) Space ~O(2N)
	public static boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(sum);
        while (!stack.isEmpty()) {
            int value = sums.pop();
            TreeNode n = stack.pop();
            if (n.left == null && n.right == null && n.val == value) return true;
            if (n.left != null) {
                stack.push(n.left);
                sums.push(value - n.val);
            }
            if (n.right != null) {
                stack.push(n.right);
                sums.push(value - n.val);
            }
        }
        return false;
	}
	

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(1);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.right = n8;
		
		System.out.println(hasPathSum2(n0, 22));
		
	}
	
}
