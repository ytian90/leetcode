package binaryTree;

import java.util.HashMap;

/**
 * 437. Path Sum III
 * @author yutian
 *
 */
public class PathSum3 {
	
	public static int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

	private static int helper(TreeNode root, int sum, int target, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		sum += root.val;
		int res = map.getOrDefault(sum - target, 0);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		res += helper(root.left, sum, target, map) + helper(root.right, sum, target, map);
		map.put(sum, map.get(sum) - 1);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
