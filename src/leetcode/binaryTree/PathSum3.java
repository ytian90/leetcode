package leetcode.binaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 * @author yutian
 *
 */
public class PathSum3 {
	
	public static int pathSum(TreeNode root, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		return helper(root, 0, sum, map);
    }

	private static int helper(TreeNode node, int sum, int target, Map<Integer, Integer> map) {
		if (node == null) return 0;
		sum += node.val;
		int res = map.getOrDefault(sum - target, 0);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		res += helper(node.left, sum, target, map) + helper(node.right, sum, target, map);
		map.put(sum, map.get(sum) - 1);
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(-3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(11);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(-2);
		TreeNode n8 = new TreeNode(1);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.right = n8;
		
		System.out.println(pathSum(n0, 8));
	}

}
