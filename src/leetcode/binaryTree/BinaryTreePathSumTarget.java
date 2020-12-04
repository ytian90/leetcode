package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Find paths in a binary search tree summing to a target value
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=164748&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 9, 2016
 */
public class BinaryTreePathSumTarget {
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		helper(root, sum, list, result);
		return result;
	}
	
	private static void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
		if (root == null) return;
		list.add(root.val);
		if (root.val == sum) {
			result.add(new ArrayList<Integer>(list));
		} else {
			helper(root.left, sum - root.val, list, result);
			helper(root.right, sum - root.val, list, result);
		}
		list.remove(list.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n2.left = n4;
		
		List<List<Integer>> res = pathSum(n0, 6);
		for (List<Integer> l: res) {
			System.out.println(l);
		}
	}

}
