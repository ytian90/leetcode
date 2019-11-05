package mj.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. lc1110
 */
public class RedBlueTree {
    public class TreeNode {
        List<TreeNode> children;
        boolean isRed;
        TreeNode(boolean isRed) {
            this.isRed = isRed;
            children = new ArrayList<>();
        }
    }

    public List<TreeNode> getBlueTrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res, true);
        return res;
    }

    public void helper(TreeNode node, List<TreeNode> res, boolean isParentRed) {
        if (node == null) {
            return;
        }
        if (node.isRed && node.children.size() == 0) {
            return;
        }
        if (!node.isRed && isParentRed) {
            res.add(node);
        }
        for (int i = 0; i < node.children.size(); i++) {
            TreeNode n = node.children.get(i);
            if (n == null) continue;
            TreeNode t = n;
            if (n.isRed) {
                node.children.remove(i);
            }
            helper(t, res, node.isRed);
        }
    }
}
