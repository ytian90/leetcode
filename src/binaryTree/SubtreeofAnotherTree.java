package binaryTree;

import java.util.Stack;

/**
 * 572. Subtree of Another Tree
 * @author ytian
 *
 */
public class SubtreeofAnotherTree {
	
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

	private static boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
	
	public static boolean isSubtree2(TreeNode s, TreeNode t) {
		String ss = helper(s);
		String tt = helper(t);
		return ss.contains(tt);
	}

	private static String helper(TreeNode node) {
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode> s = new Stack<>(); // can't use Deque
		s.push(node);
		while (!s.isEmpty()) {
			TreeNode curr = s.pop();
			if (curr == null) {
				sb.append(",#"); // Appending # in order to handle same values but not subtree cases
			} else {
				sb.append("," + curr.val);
			}
			if (curr != null) {
				s.push(curr.left);
				s.push(curr.right);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		
		n1.left = n2; n1.right = n3; n2.left = n4; n2.right = n5;
		
		System.out.println(isSubtree2(n1, n2));
		
		
	}

}
