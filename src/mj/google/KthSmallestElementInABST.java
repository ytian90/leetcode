package mj.google;

/**
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{0, 0};
        helper(root, res, k);
        return res[0];
    }

    private void helper(TreeNode node, int[] res, int k) {
        if (node.left != null) {
            helper(node.left, res, k);
        }
        res[1]++;
        if (res[1] == k) {
            res[0] = node.val;
            return;
        }
        if (node.right != null) {
            helper(node.right, res, k);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest
    // frequently? How would you optimize the kthSmallest routine?
    public int kthSmallest2(TreeNode root, int k) {
        TreeNodeWithCount rootWithCount = build(root);
        return kthSmallest(rootWithCount, k);
    }

    private TreeNodeWithCount build(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
        rootWithCount.left = build(root.left);
        rootWithCount.right = build(root.right);
        if (rootWithCount.left != null) {
            rootWithCount.count += rootWithCount.left.count;
        }
        if (rootWithCount.right != null) {
            rootWithCount.count += rootWithCount.right.count;
        }
        return rootWithCount;
    }

    private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
        if (k <= 0 || k > rootWithCount.count) {
            return -1;
        }
        if (rootWithCount.left != null) {
            if (rootWithCount.left.count >= k) {
                return kthSmallest(rootWithCount.left, k);
            }
            if (rootWithCount.left.count == k - 1) {
                return rootWithCount.val;
            }
            return kthSmallest(rootWithCount.right, k - 1 - rootWithCount.left.count);
        } else {
            if (k == 1) {
                return rootWithCount.val;
            } else {
                return kthSmallest(rootWithCount.right, k - 1);
            }
        }
    }

    public class TreeNodeWithCount {
        int val;
        int count;
        TreeNodeWithCount left;
        TreeNodeWithCount right;
        TreeNodeWithCount(int x) {
            this.val = x;
            this.count = 1;
        }
    }
}
