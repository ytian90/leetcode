package binaryTree;

import javafx.util.Pair;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 */
public class SmallestSubtreeWithAllTheDeepestNodes {
    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).getValue();
    }

    public static Pair<Integer, TreeNode> helper(TreeNode node) {
        if (node == null) return new Pair(0, null);
        Pair<Integer, TreeNode> l = helper(node.left), r = helper(node.right);
        int d1 = l.getKey(), d2 = r.getKey();
        return new Pair(1 + Math.max(d1, d2), d1 == d2 ? node : d1 > d2 ? l.getValue() : r.getValue());
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(4);

        n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4; n2.left = n5; n2.right = n6;
        n4.left = n7; n4.right = n8;

        System.out.println(subtreeWithAllDeepest(n0).val);
    }

}
