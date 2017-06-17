package binaryTree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Binary tree preorder iterator
 * 1. save all nodes in a arrayList O(n)
 * 2. use stack o(logn)
 * https://shawnlincoding.wordpress.com/page/4/
 * @author yutian
 * @since Feb 5, 2016
 */
public class BSTIteratorPreorder {
	
	private Stack<TreeNode> stack;
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int v) {
			val = v;
		}
	}
	
	public BSTIteratorPreorder (TreeNode root) {
		if (root == null) 
			throw new IllegalArgumentException();
		stack = new Stack<TreeNode>();
		stack.push(root);
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		if (!hasNext()) throw new NoSuchElementException();
		TreeNode curr = stack.pop();
		if (curr.right != null) {
			stack.push(curr.right);
		}
		if (curr.left != null) {
			stack.push(curr.left);
		}
		return curr.val;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(30);
		n2.left = n3;
		n2.right = n4;
		n0.left = n1;
		n0.right = n2;
		BSTIteratorPreorder it = new BSTIteratorPreorder(n0);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
