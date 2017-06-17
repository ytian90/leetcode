package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 314. Binary Tree Vertical Order Traversal
 * @author yutian
 * @since Jan 6, 2016
 */
public class BinaryTreeVerticalOrderTraversal {
	
	// Time ~O(N), Space ~O(3N)
	public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(0);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
        	TreeNode curr = q.poll();
        	int col = cols.poll();
        	if (!map.containsKey(col)) map.put(col, new ArrayList<>());
        	map.get(col).add(curr.val);
        	
        	if (curr.left != null) {
        		q.add(curr.left);
        		cols.add(col - 1);
        		if (col - 1 < min) min = col - 1;
        	}
        	if (curr.right != null) {
        		q.add(curr.right);
        		cols.add(col + 1);
        		if (col + 1 > max) max = col + 1;
        	}
        }
        for (int i = min; i <= max; i++) {
        	res.add(map.get(i));
        }
        return res;
    }

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		
		n0.left = n1; n0.right = n2;
		n2.left = n3; n2.right = n4;
		
		System.out.println(verticalOrder(n0));
	}

}
