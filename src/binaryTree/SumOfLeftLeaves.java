package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 404. Sum of Left Leaves
 * @author yutian
 *
 */
public class SumOfLeftLeaves {
	
	// Recursive
	public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        if (root.left != null) {
        	if (root.left.left == null && root.left.right == null) res += root.left.val;
        	else res += sumOfLeftLeaves(root.left);
        }
        res += sumOfLeftLeaves(root.right);
        return res;
    }
	
	// Iterative
	public static int sumOfLeftLeaves2(TreeNode root) {
		if (root == null) return 0;
		int res = 0;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr.left != null) {
				if (curr.left.left == null && curr.left.right == null) {
					res += curr.left.val;
				} else {
					stack.push(curr.left);
				}
			}
			if (curr.right != null) {
				if (curr.right.left != null || curr.right.right != null) {
					stack.push(curr.right);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		
		n0.left = n1;
		n0.right = n2;
		n2.left = n3;
		n2.right = n4;
		
		System.out.println(sumOfLeftLeaves(n0));
		
	}

}
