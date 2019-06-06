package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. Print Binary Tree
 */
public class PrintBinaryTree {

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = root == null ? 1 : height(root);
        int row = height, col = (int) (Math.pow(2, height) - 1);
        List<String> list = new ArrayList<>();
        // prepare template
        for (int i = 0; i < col; i++) {
            list.add("");
        }
        for (int i = 0; i < row; i++) {
            res.add(new ArrayList<>(list));
        }
        helper(root, res, 0, row, 0, col - 1);
        return res;
    }

    public static void helper(TreeNode node, List<List<String>> res, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (node == null || rowStart == rowEnd) {
            return;
        }
        res.get(rowStart).set((colStart + colEnd) / 2, String.valueOf(node.val));
        helper(node.left, res, rowStart + 1, rowEnd, colStart, (colStart + colEnd) / 2 - 1);
        helper(node.right, res, rowStart + 1, rowEnd, (colStart + colEnd) / 2 + 1, colEnd);
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        n0.left = n1;
        System.out.println(printTree(n0));
    }

}
