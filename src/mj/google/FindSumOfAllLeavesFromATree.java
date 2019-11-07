package mj.google;

import binaryTree.TreeNode;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=568082&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D9%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class FindSumOfAllLeavesFromATree {

    static int sum = 0;

    public static int sumAllLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        helper(root);
        return sum;
    }

    private static void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.val;
        }
        helper(node.left);
        helper(node.right);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);

        n0.left = n1;
        n0.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;

        System.out.println(sumAllLeaves(n0));
    }
}
