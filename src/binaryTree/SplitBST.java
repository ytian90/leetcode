package binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 776. Split BST
 */
public class SplitBST {

    // balanced BST O(logN), worst case O(N)
    public static TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode[] res;
        if (root.val <= V) {
            res = splitBST(root.right, V);
            root.right = res[0];
            res[0] = root;
        } else {
            res = splitBST(root.left, V);
            root.left = res[1];
            res[1] = root;
        }
        return res;
    }

    public static TreeNode[] splitBSTs(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) return  res;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null) {
            stack.push(root);
            if (root.val <= V) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val <= V) {
                curr.right = res[0];
                res[0] = curr;
            } else {
                curr.left = res[1];
                res[1] = curr;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(7);
        n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4;
        n2.left = n5; n2.right = n6;
        for (TreeNode tn : splitBST(n0, 2)) {
            System.out.println(tn.val);
        }
    }

}
