package binaryTree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * Inorder traversal
 * @author yutian
 * @since Aug 11, 2015
 */
public class BSTIterator {
	private static Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
        pushLeftChildren(root);
    }

    private static void pushLeftChildren(TreeNode curr) {
    	while (curr != null) {
    		stack.add(curr);
    		curr = curr.left;
    	}
	}

	/** @return whether we have a next smallest number */
    public static boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public static int next() {
    	// don't forget hasNext() 's ()
//        if (!hasNext()) throw new NoSuchElementException("All nodes have been visited.");
        TreeNode res = stack.pop();
        pushLeftChildren(res.right);
        return res.val;
    }
    
    public static void main(String[] args) {
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(12);
		
		n0.left = n1; n0.right = n2;
		n1.left = n3; n1.right = n4;
		n2.left = n5;
		
		BSTIterator i = new BSTIterator(n0);
		while (i.hasNext()) System.out.println(i.next());
		
		
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
