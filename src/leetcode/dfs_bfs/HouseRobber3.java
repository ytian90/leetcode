package leetcode.dfs_bfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 * @author yutian
 * @since Apr 8, 2016
 */
public class HouseRobber3 {
	
	// Method 1 time ~O(N) space ~O(N)
	public int rob(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
	
	private int helper(TreeNode node, Map<TreeNode, Integer> map) {
		if (node == null) return 0;
		if (map.containsKey(node)) return map.get(node);
        int val = 0;
        if (node.left != null) {
        	val += helper(node.left.left, map) + helper(node.left.right, map);
        }
        if (node.right != null) {
        	val += helper(node.right.left, map) + helper(node.right.right, map);
        }
        val = Math.max(val + node.val, helper(node.left, map) + helper(node.right, map));
        map.put(node, val);
        return val;
	}
	
	// Method 2 time ~O(N) space ~O(N)
	public int rob2(TreeNode root) {
		int[] res = helper(root);
		return Math.max(res[0], res[1]);
	}
	
	private int[] helper(TreeNode node) {
		if (node == null) return new int[2];
		int[] left = helper(node.left);
		int[] right = helper(node.right);
		/*
		 * res[0] -> maximum amount of $ if "node" is not robbed
		 * res[1] -> maximum amount of $ if "node" is robbed
		 */
		int[] res = new int[2];
		// if not rob "node", pick max from left and right
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// if rob "node", add together with max of not rob left and not rob right
		res[1] = node.val + left[0] + right[0];
		return res;
	}

	public static void main(String[] args) {
		HouseRobber3 t = new HouseRobber3();
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(1);
		
		n0.left = n1; n0.right = n2; n1.right = n3; n2.right = n4;
		System.out.println(t.rob(n0));
		
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(5);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(3);
		TreeNode n10 = new TreeNode(1);
		
		n5.left = n6; n5.right = n7; n6.left = n8; n6.right = n9; n7.right = n10;
		System.out.println(t.rob2(n5));
		
	}

	
	// Definition for a binary tree node
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
}
