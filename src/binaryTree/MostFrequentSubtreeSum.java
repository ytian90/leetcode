package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum
 * @author ytian
 *
 */
public class MostFrequentSubtreeSum {
	
	Map<Integer, Integer> map;
	int max;
	
	public int[] findFrequentTreeSum(TreeNode root) {
		map = new HashMap<>();
		max = Integer.MIN_VALUE;
		helper(root);
		List<Integer> res = new ArrayList<>();
		for (int key: map.keySet()) {
			if (map.get(key) == max) {
				res.add(key);
			}
		}
		return res.stream().mapToInt(i->i).toArray();
    }	

	private int helper(TreeNode node) {
		if (node == null) return 0;
		int left = helper(node.left);
		int right = helper(node.right);
		int sum = left + right + node.val;
		int count = map.getOrDefault(sum, 0) + 1;
		map.put(sum, count);
		max = Math.max(max, count);
		return sum;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(-3);
		n1.left = n2; n1.right = n3;
		
		MostFrequentSubtreeSum t = new MostFrequentSubtreeSum();
		for (int i : t.findFrequentTreeSum(n1)) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		TreeNode n11 = new TreeNode(5);
		TreeNode n21 = new TreeNode(2);
		TreeNode n31 = new TreeNode(-5);
		n11.left = n21; n11.right = n31;
		
		for (int i : t.findFrequentTreeSum(n11)) {
			System.out.print(i + " ");
		}
	}

}
