package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 * @author ytian
 *
 */
public class AverageofLevelsinBinaryTree {
	
	public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root == null) return res;
        q.add(root);
        while (!q.isEmpty()) {
        	int n = q.size();
        	double sum = 0.0;
        	for (int i = 0; i < n; i++) {
        		TreeNode curr = q.poll();
        		sum += curr.val;
        		if (curr.left != null) q.offer(curr.left);
        		if (curr.right != null) q.offer(curr.right);
        	}
        	res.add(sum / n);
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
		
		System.out.println(averageOfLevels(n0));
		
	}

}
