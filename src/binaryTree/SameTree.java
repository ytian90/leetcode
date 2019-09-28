package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * @author yutian
 * @since Aug 10, 2015
 */
public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null && q != null) {
			return false;
		} else if (p != null && q == null) {
			return false;
		} else if (p != null && q != null && p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.left = new TreeNode(2);
		n0.right = new TreeNode(3);
		TreeNode n1 = new TreeNode(1);
		n1.left = new TreeNode(2);
		n1.right = new TreeNode(3);
		System.out.println(isSameTree(n0, n1));

		TreeNode n2 = new TreeNode(1);
		n2.left = new TreeNode(2);
		TreeNode n3 = new TreeNode(1);
		n3.right = new TreeNode(2);
		System.out.println(isSameTree(n2, n3));

		TreeNode n4 = new TreeNode(1);
		n4.left = new TreeNode(2);
		n4.right = new TreeNode(1);
		TreeNode n5 = new TreeNode(1);
		n5.left = new TreeNode(1);
		n5.right = new TreeNode(2);
		System.out.println(isSameTree(n4, n5));
	}

	// recursion Time ~O(N) Space ~O(1)
	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null || p.val != q.val) return false;
		return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
	}
	
	// queue Time ~O(N), Space ~O(N)
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.offer(p);
		q2.offer(q);
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			TreeNode x = q1.poll();
			TreeNode y = q2.poll();
			if (x == null && y == null) continue;
			if ((x != null && y == null) || (x == null && y != null) || (x.val != y.val)) {
				return false;
			}
			q1.offer(x.left);
			q1.offer(x.right);
			q2.offer(y.left);
			q2.offer(y.right);
		}
		return true;
	}
}
