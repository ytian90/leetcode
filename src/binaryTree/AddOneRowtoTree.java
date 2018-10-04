package binaryTree;

import util.BTreePrinter;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 623. Add One Row to Tree
 * @author ytian
 *
 */
public class AddOneRowtoTree {

	// BFS
	public static TreeNode addOneRow1(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode nn = new TreeNode(v);
			nn.left = root;
			return nn;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		for (int i = 0; i < d - 2; i++) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				TreeNode t = q.poll();
				if (t.left != null) q.add(t.left);
				if (t.right != null) q.add(t.right);
			}
		}
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			TreeNode t = curr.left;
			curr.left = new TreeNode(v);
			curr.left.left = t;
			t = curr.right;
			curr.right = new TreeNode(v);
			curr.right.right = t;
		}
		return root;
	}

	// DFS
	public static TreeNode addOneRow2(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode nn = new TreeNode(v);
			nn.left = root.left;
			return nn;
		}
		dfs(root, v, d, 1);
		return root;
	}

	public static void dfs(TreeNode node, int v, int d, int depth) {
		if (node == null) return;
		if (depth < d - 1) {
			dfs(node.left, v, d, depth + 1);
			dfs(node.right, v, d, depth + 1);
		} else {
			TreeNode t = node.left;
			node.left = new TreeNode(v);
			node.left.left = t;
			t = node.right;
			node.right = new TreeNode(v);
			node.right.right = t;
		}
	}

	// DFS without helper
	public static TreeNode addOneRow3(TreeNode root, int v, int d) {
		if (d < 2) {
			TreeNode nn = new TreeNode(v);
			if (d == 0) nn.right = root;
			else nn.left = root;
			return nn;
		}
		if (root == null) return null;
		root.left = addOneRow3(root.left, v, d == 2 ? 1 : d - 1);
		root.right = addOneRow3(root.right, v, d == 2 ? 0 : d - 1);
		return root;
	}
	
	public static TreeNode addOneRow(TreeNode root, int v, int d) {
        return helper(root, v, d, 1, 0);
    }
	
	private static TreeNode helper(TreeNode node, int v, int d, int level, int dir) {
		if (d == level) {
			TreeNode nn = new TreeNode(v);
			if (dir == 0) {
				nn.left = helper(node, v, d, level + 1, 0);
			} else {
				nn.right = helper(node, v, d, level + 1, 1);
			}
			return nn;
		}
		if (node == null) return null; // Should not be at top, corner case is below
		node.left = helper(node.left, v, d, level + 1, 0);
		node.right = helper(node.right, v, d, level + 1, 1);
		return node;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6;
		
		BTreePrinter.printTreeNode(addOneRow(n1, 1, 2));
		
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(3);
		TreeNode n0 = new TreeNode(1);
		n7.left = n8; n8.left = n9; n8.right = n0;
		
		BTreePrinter.printTreeNode(addOneRow(n7, 1, 3));
		
		// corner case for line 26
		TreeNode n11 = new TreeNode(1);
		TreeNode n12 = new TreeNode(2);
		TreeNode n13 = new TreeNode(3);
		TreeNode n14 = new TreeNode(4);
		n11.left = n12; n11.right = n13; n12.left = n14;
		
		BTreePrinter.printTreeNode(addOneRow(n11, 5, 4));
		
	}

}
