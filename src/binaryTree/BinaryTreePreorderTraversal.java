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
	
	// Time ~O(N) Space ~O(N)
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		LinkedList<TreeNode> stack = new LinkedList<>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        if (node != null) {
	            result.add(node.val);
	            stack.push(node.right);
	            stack.push(node.left);
	        }
	    }
	    return result;
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
