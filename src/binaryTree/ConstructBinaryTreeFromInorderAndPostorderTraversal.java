package binaryTree;

import util.BTreePrinter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * @author yutian
 * @since Aug 21, 2015
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null
                || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int len = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, len - 1, 0, len - 1, map);
    }

    public TreeNode helper(int[] postorder, int curr, int start, int end,
                           Map<Integer, Integer> map) {
        TreeNode root = new TreeNode(postorder[curr]);
        if (start >= end) return root;
        int mid = map.get(postorder[curr]);
        if (mid > start) {
            root.left = helper(postorder, curr - (end - mid) - 1, start, mid - 1, map);
        }
        if (mid < end) {
            root.right = helper(postorder, curr - 1, mid + 1, end, map);
        }
        return root;
    }

	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal z = 
				new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		TreeNode t = z.buildTree(new int[]{10, 5, 3, 7, 15, 12}, 
				new int[]{3, 5, 7, 10, 12, 15});
		BTreePrinter.printTreeNode(t);
	}

}
