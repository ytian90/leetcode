package company.apple;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=749381&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 *
 * https://leetcode.com/discuss/interview-question/algorithms/124561/google-phone-interview-question-round-2/126178
 */
public class FindNodeWithTwoParentsAndFix {
    private static Set<TreeNode> visited = new HashSet<>();

    public static void fix(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        if (!visited.contains(node)) {
            visited.add(node);
            fix(node.left, node);
            fix(node.right, node);
        } else {
            if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node) {
                parent.right = null;
            }
        }

    }

    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
