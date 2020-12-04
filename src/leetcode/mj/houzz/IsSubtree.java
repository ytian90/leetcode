package leetcode.mj.houzz;

import leetcode.binaryTree.TreeNode;

/**
 * 题目是，给两个二叉树s和t，需要判断t是否是s的某一个subtree。
 * 先说了brute-force的方法，然后分析了一下时间复杂度，然后开始优化，当时直觉是用inorder-traverse转化成string来做，但是最开始中间还是有bug
 *        1               2
 *      /   \               \
 *    2     3  和             1，  如果仅仅考虑inorder的情况，显然是不对了。
 *
 * https://www.1point3acres.com/bbs/thread-463311-1-1.html
 */
public class IsSubtree {

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }

    public static void main(String[] args) {

    }
}
