package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Lowest Common Ancestor of a Binary Tree
 * @author yutian
 * @since Aug 29, 2015
 */
public class LowestCommonAncestorOfABinaryTree {
	
	// DFS Time ~O(N) Space O(N)
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}
	
	// much more slow compared to the first one
	public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		parent.put(root, null);
		stack.push(root);
		
		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				parent.put(node.left, node);
				stack.push(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		
		Set<TreeNode> ancestors = new HashSet<>();
		while (p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		while (!ancestors.contains(q)) {
			q = parent.get(q);
		}
		return q;
	}
	
	private static TreeNode makeTree() {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(0);
		TreeNode n6 = new TreeNode(8);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(4);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n4.left = n7;
		n4.right = n8;
		
		return n0;
	}
	
	public static void main(String[] args) {
		TreeNode root = makeTree();
//		System.out.println(lowestCommonAncestor(root, root.left, root.right).val);
		System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
	}
}
