package leetcode.binaryTree;

/**
 * 700. Search in a Binary Search Tree
 */
public class SearchInABinarySearchTree {

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static TreeNode searchBSTs(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);

        n0.left = n1; n0.right = n2;
        n1.left = n3; n1.right = n4;

        System.out.println(searchBST(n0, 2).val);
    }
}
