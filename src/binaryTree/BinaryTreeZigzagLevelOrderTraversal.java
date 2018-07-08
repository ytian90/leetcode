package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
	// Solution 1 Time ~O(N) Space ~O(N)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		boolean ch = true;
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (ch) {
					list.add(curr.val);
				} else {
					list.add(0, curr.val);
				}
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
			res.add(list);
			ch = !ch;
		}
		return res;
	}
	
	// Solution 2 Better way DFS
//		private static List<List<Integer>> result = new ArrayList<List<Integer>>();
		
	public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(root, 0, res);
		return res;
	}

	private static void helper(TreeNode node, int n, List<List<Integer>> res) {
		if (node == null) return;
		if (res.size() == n)
			res.add(new ArrayList<>());
		if (n % 2 == 0) res.get(n).add(node.val);
		if (n % 2 == 1) res.get(n).add(0, node.val);
		helper(node.left, n + 1, res);
		helper(node.right, n + 1, res);
	}
	
	// BFS: Time ~ O(N), Space ~ O(N)
	// Use two stack, stack store the nodes of current line, stackTmp store nodes for next line
	// use a boolean to decide direction
	// When oddLevel = true, right to left;  oddLevel = false, left to right;
	public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
		List<List<Integer>> listSet = new ArrayList<List<Integer>>();
		if (root == null) return listSet;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		boolean oddLevel = false; // false - 0, 2, 4, ... levels
		while (!stack.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			Stack<TreeNode> stackTmp = new Stack<>();
			while (!stack.isEmpty()) {
				TreeNode curr = stack.pop();
				list.add(curr.val);
				if (oddLevel) {
					if (curr.right != null) stackTmp.push(curr.right);
					if (curr.left != null) stackTmp.push(curr.left);
				} else {
					if (curr.left != null) stackTmp.push(curr.left);
					if (curr.right != null) stackTmp.push(curr.right);
				}
			}
			listSet.add(list);
			stack = stackTmp;
			oddLevel = !oddLevel;
		}
		return listSet;
	}
	
	
	
	private static TreeNode makeTree() {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		n0.left = n1;
		n0.right = n2;
		n2.left = n3;
		n2.right = n4;
		return n0;
	}
	
	public static void main(String[] args){
		TreeNode root = makeTree();
		System.out.println(zigzagLevelOrder2(root));
	}
	
}
