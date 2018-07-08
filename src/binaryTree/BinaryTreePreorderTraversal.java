package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreePreorderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	private static void helper(TreeNode node, List<Integer> res) {
		if (node == null) return;
		res.add(node.val);
		helper(node.left, res);
		helper(node.right, res);
	}
	
	// Time ~O(N) Space ~O(N)
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if (node.right != null) stack.push(node.right);
			if (node.left != null) stack.push(node.left);
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.right = n1; n1.left = n2;

	}
	
	// root-left-right
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while (curr != null) {
			list.add(curr.val);
			stack.push(curr);
			curr = curr.left;
		}
		
		while (!stack.isEmpty()) {
			curr = stack.pop();
			curr = curr.right;
			while (curr != null) {
				list.add(curr.val);
				stack.push(curr);
				curr = curr.left;
			}
		}
		return list;
	}
}
