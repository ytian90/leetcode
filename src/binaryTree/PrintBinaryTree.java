package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. Print Binary Tree
 */
public class PrintBinaryTree {

    public static List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = (root == null) ? 1 : height(root);
        int row = height, col = (int) (Math.pow(2, height) - 1);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < col; i++)
            list.add("");
        for (int i = 0; i < row; i++)
            res.add(new ArrayList<>(list));
        helper(root, res, 0, row, 0, col - 1);
        return res;
    }

    public static void helper(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        if (row == totalRows || root == null) return;
        res.get(row).set((i + j) /2, Integer.toString(root.val));
        helper(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1);
        helper(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j);
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        n0.left = n1;
        System.out.println(printTree(n0));
    }

}
