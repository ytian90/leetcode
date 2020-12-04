package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 965. Univalued Binary Tree
 */
public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }

    private boolean dfs(TreeNode n, int v) {
        if (n == null) { return true; }
        if (n.val != v) { return false; }
        return dfs(n.left, v) && dfs(n.right, v);
    }

    public boolean isUnivalTree2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n.val != root.val) { return false; }
            if (n.left != null) { q.offer(n.left); }
            if (n.right != null) { q.offer(n.right); }
        }
        return true;
    }
}
