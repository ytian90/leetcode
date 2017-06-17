package binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * @author yutian
 * @since Aug 21, 2015
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	
	// Solution 0
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(0, 0, inorder.length - 1, preorder, map);
    }
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, 
    		Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inIndex = map.get(root.val);
		root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, map);
		root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, 
				inEnd, preorder, map);
		return root;
    }
	
 // Solution 3 Recursive Solution
 	public TreeNode buildTree3(int[] preorder, int[] inorder) {
 		return helper(preorder, inorder, 0, 0, inorder.length - 1);
 	}
 	
 	private TreeNode helper(int[] preorder, int[] inorder, int preStart,
 			int inStart, int inEnd) {
 		if (preStart > preorder.length - 1 || inStart > inEnd) return null;
 		TreeNode root = new TreeNode(preorder[preStart]);
 		int inIndex = 0; // Index of current root in inorder
 		for (int i = inStart; i <= inEnd; i++) { // cost too much!
 			if (inorder[i] == root.val) inIndex = i;
 		}
 		root.left = helper(preorder, inorder, preStart + 1, inStart, inIndex - 1);
 		root.right = helper(preorder, inorder, preStart + inIndex - inStart + 1, 
 				inIndex + 1, inEnd);
 		return root;
 	}
	
	// Solution 1
	private Map<Integer, Integer> inorderMap = new HashMap<>();
	
	public TreeNode buildTree1(int[] preorder, int[] inorder) {
		int len = inorder.length;
		if (len < 1) return null;
		for (int i = 0; i < len; i++) {
			inorderMap.put(inorder[i], i);
		}
		return buildSubTree(preorder, 0, 0, len - 1);
	}

	private TreeNode buildSubTree(int[] preorder, int curr, int start, int end) {
		TreeNode root = new TreeNode(preorder[curr]);
		if (start < end) {
			int mid = inorderMap.get(preorder[curr]);
			if (mid > start) {
				root.left = buildSubTree(preorder, curr + 1, start, mid - 1);
			} // This is if not else if 
			if (mid < end) {
				// mid - start = # of left subtree nodes
				root.right = buildSubTree(preorder, curr + mid - start + 1, mid + 1, end);
			}
		}
		return root;
	}
	
	// Solution 2 Recursive Solution
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		return buildTreeIntern(preorder, inorder, 0, 0, preorder.length);
	}
	
	private TreeNode buildTreeIntern(int[] preorder, int[] inorder, int preIndex,
			int inIndex, int size) {
		if (size <= 0) return null;
		TreeNode result = new TreeNode(preorder[preIndex]);
		for (int i = 0; i < size; i++) {
			if (preorder[preIndex] == inorder[inIndex + i]) {
				result.left = buildTreeIntern(preorder, inorder, preIndex + 1, inIndex, i);
				result.right = buildTreeIntern(preorder, inorder, preIndex + i + 1, 
						inIndex + i + 1, size - i - 1);
				break;
			}
		}
		return result;
	}
	
	
	
	// Solution 4 Iterative Solution
	public TreeNode buildTree4(int[] preorder, int[] inorder) {
		if (inorder.length == 0) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = new TreeNode(Integer.MIN_VALUE);
		stack.push(root);
		int i = 0, j = 0;
		TreeNode node = null;
		TreeNode cur = root;
		while (j < inorder.length) {
			if (stack.peek().val == inorder[j]) {
				node = stack.pop();
				j++;
			} else if (node != null) {
				cur = new TreeNode(preorder[i]);
				node.right = cur;
				node = null;
				stack.push(cur);
				i++;
			} else {
				cur = new TreeNode(preorder[i]);
				stack.peek().left = cur;
				stack.push(cur);
				i++;
			}
		}
		return root.left;
	}
}
