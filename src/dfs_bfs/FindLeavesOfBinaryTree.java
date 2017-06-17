package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 * @author yutian
 * @since Jul 3, 2016
 */
public class FindLeavesOfBinaryTree {
	
	private static List<List<Integer>> res = new ArrayList<>();
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return res;
    }
	
	private static int helper(TreeNode node) {
		if (node == null) return -1;
		int level = 1 + Math.max(helper(node.left), helper(node.right));
		if (res.size() - 1 < level) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(node.val);
		return level;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		n0.left = n1; n0.right = n2;
		n1.left = n3; n1.right = n4;
		for (List<Integer> l : findLeaves(n0)) {
			System.out.println(l);
		}
		
	}

}
