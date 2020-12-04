package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. Find Bottom Left Tree Value
 * @author ytian
 *
 */
public class FindBottomLeftTreeValue {
	/*
	 * Doing BFS right-to-left means we can simply return the last node's value and don't have to keep track
	 * of the first node in the current row or even care about rows at all.
	 */
	public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
        	root = q.poll();
        	if (root.right != null) {
        		q.add(root.right);
        	}
        	if (root.left != null) {
        		q.add(root.left);
        	}
        }
        return root.val;
    }
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n3.left = n5; 
		n3.right = n6; n5.left = n7;
		
		System.out.println(findBottomLeftValue(n1));
		
	}
}
