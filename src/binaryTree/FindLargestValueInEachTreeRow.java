package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 * @author ytian
 *
 */
public class FindLargestValueInEachTreeRow {
	
	// BFS
	public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
        	int size = q.size(), max = Integer.MIN_VALUE;
        	for (int i = 0; i < size; i++) {
        		TreeNode curr = q.poll();
        		max = Math.max(max, curr.val);
        		if (curr.left != null) q.add(curr.left);
        		if (curr.right != null) q.add(curr.right);
        	}
        	res.add(max);
        }
        return res;
    }
	
	// DFS
	public static List<Integer> largestValues2(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res, 0);
		return res;
	}

	private static void helper(TreeNode node, List<Integer> res, int depth) {
		if (node == null) return;
		if (depth == res.size()) res.add(node.val);
		else res.set(depth, Math.max(res.get(depth), node.val));
		helper(node.left, res, depth + 1);
		helper(node.right, res, depth + 1);
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(9);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		
		System.out.println(largestValues(n1));
		System.out.println(largestValues2(n1));
	}

}
