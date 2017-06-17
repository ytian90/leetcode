package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same Tree
 * @author yutian
 * @since Aug 10, 2015
 */
public class SameTree {
	// recursion Time ~O(N) Space ~O(1)
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		if (p == null || q == null || p.val != q.val) return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
