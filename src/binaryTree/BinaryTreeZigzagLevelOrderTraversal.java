package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Binary Tree Zigzag Level Order Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	
	// Solution 1 Time ~O(N) Space ~O(N)
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean odd = true;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (odd) {
					list.add(curr.val);
				} else {
					list.add(0, curr.val);
				}
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
			result.add(list);
			odd = !odd;
		}
		return result;
	}
	
	// Solution 2 Better way DFS
//		private static List<List<Integer>> result = new ArrayList<List<Integer>>();
		
	public static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		zigzag(result, root, 0);
		return result;
	}
	
	private static void zigzag(List<List<Integer>> result, TreeNode root, int n) {
		if (root == null) return;
		if (result.size() == n) result.add(new ArrayList<Integer>());
		if (n % 2 == 1) result.get(n).add(0, root.val);
		if (n % 2 == 0) result.get(n).add(root.val);
		zigzag(result, root.left, n + 1);
		zigzag(result, root.right, n + 1);
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
