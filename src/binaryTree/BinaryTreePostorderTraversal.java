package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Stack<TreeNode> stackBack = new Stack<>(); // mirrored preorder
		Stack<Integer> stack = new Stack<>(); // store mirrored preorder results
		TreeNode curr = root;
		while (curr != null) {
			stack.push(curr.val);
			stackBack.push(curr);
			curr = curr.right;
		}
		while (!stackBack.isEmpty()) {
			curr = stackBack.pop();
			curr = curr.left;
			while (curr != null) {
				stack.push(curr.val);
				stackBack.push(curr);
				curr = curr.right;
			}
		}
		// reverse: root-left-right (preorder) => right-left-root(postorder)
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
	}
}
