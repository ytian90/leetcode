package leetcode.binaryTree;

/**
 * 671. Second Minimum Node in a Binary Tree
 */
public class SecondMinimumNodeInABinaryTree {

    public static int findSecondMinimumValue0(TreeNode root) {
        if (root == null) return -1;
        int[] num = new int[]{root.val, Integer.MAX_VALUE};
        dfs(root, num);
        return num[1] == Integer.MAX_VALUE ? -1 : (int) num[1];
    }

    private static void dfs(TreeNode node, int[] num) {
        if (node.val != num[0]) {
            num[1] = Math.min(num[1], node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, num);
        }
        if (node.right != null) {
            dfs(node.right, num);
        }
    }

    public static int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        int left = root.val != root.left.val ? root.left.val : findSecondMinimumValue(root.left);
        int right = root.val != root.right.val ? root.right.val : findSecondMinimumValue(root.right);
        return Math.min(left, right) == -1 ? Math.max(left, right) : Math.min(left, right);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(2);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(7);
        n0.left = n1; n0.right = n2; n2.left = n3; n2.right = n4;
        System.out.println(findSecondMinimumValue0(n0));

        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(7);
        TreeNode n7 = new TreeNode(7);
        n5.left = n6; n5.right = n7;
        System.out.println(findSecondMinimumValue0(n5));
    }

    public static int findSecondMinimumValuu(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int left = root.left.val;
        int right = root.right.val;

        if (root.left.val == root.val) {
            left = findSecondMinimumValuu(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValuu(root.right);
        }
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }
}
