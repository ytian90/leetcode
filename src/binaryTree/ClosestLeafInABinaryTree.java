package binaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 742. Closest Leaf in a Binary Tree
 * @author ytian
 *
 */
public class ClosestLeafInABinaryTree {
	
	// time O(N) space O(N)
	public static int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();
        
        for (TreeNode node : graph.keySet()) {
        		if (node != null && node.val == k) {
        			q.add(node);
        			seen.add(node);
        		}
        }
        
        while (!q.isEmpty()) {
        		TreeNode node = q.poll();
        		if (node != null) {
        			if (graph.get(node).size() <= 1) {
        				return node.val;
        			}
        			for (TreeNode n : graph.get(node)) {
        				if (!seen.contains(n)) {
        					seen.add(n);
        					q.add(n);
        				}
        			}
        		}
        }
        throw null;
    }

	public static void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
		if (node != null) {
			if (!graph.containsKey(node))
				graph.put(node, new LinkedList<TreeNode>());
			if (!graph.containsKey(parent))
				graph.put(parent, new LinkedList<TreeNode>());
			graph.get(node).add(parent);
			graph.get(parent).add(node);
			dfs(graph, node.left, node);
			dfs(graph, node.right, node);
		}
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		n0.left = n1; n0.right = n2;
		System.out.println(findClosestLeaf(n0, 1));
		
		TreeNode n3 = new TreeNode(1);
		System.out.println(findClosestLeaf(n3, 1));
		
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(6);
		n4.left = n5; n4.right = n6;
		n5.left = n7; n7.left = n8; n8.left = n9;
		System.out.println(findClosestLeaf(n4, 2));
	}

}
