package leetcode.binaryTree;

/**
 * 872. Leaf-Similar Trees
 */
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals(dfs(root2));
    }

    private String dfs(TreeNode node) {
        return node == null ? "" : node.left == null && node.right == null
                ? node.val + "," : dfs(node.left) + dfs(node.right);
    }

    public boolean leafSimilarr(TreeNode root1, TreeNode root2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        helper(root1, s1);
        helper(root2, s2);

        return s1.toString().equals(s2.toString());
    }

    public void helper(TreeNode node, StringBuilder sb) {
        if (node.left == null && node.right == null) {
            sb.append(node.val + "");
            return;
        }
        if (node.left != null) helper(node.left, sb);
        if (node.right != null) helper(node.right, sb);
    }
}
