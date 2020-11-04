package util;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class temp {

    public static void recoverTree(TreeNode root) {
        List<TreeNode> nodeVals = new ArrayList<>();
        recover(root, nodeVals);
        int[] pos = findTwoSwapped(nodeVals.stream().map(a -> a.val).collect(Collectors.toList()));
        int val = nodeVals.get(pos[0]).val;
        nodeVals.get(pos[0]).val = nodeVals.get(pos[1]).val;
        nodeVals.get(pos[1]).val = val;
    }

    private static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for(int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                // first swap occurence
                if (x == -1) x = nums.get(i);
                    // second swap occurence
                else break;
            }
        }
        return new int[]{x, y};
    }

    private static void recover(TreeNode node, List<TreeNode> nodeVals) {
        if (node == null) {
            return;
        }
        recover(node.left, nodeVals);
        nodeVals.add(node);
        recover(node.right, nodeVals);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.left.right = new TreeNode(2);
        BTreePrinter.printTreeNode(node);
        recoverTree(node);
        System.out.println();
        BTreePrinter.printTreeNode(node);

        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(4);
        node1.right.left = new TreeNode(2);
        BTreePrinter.printTreeNode(node1);
        recoverTree(node1);
        System.out.println();
        BTreePrinter.printTreeNode(node1);
    }

//    private static TreeNode recover(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode left = recover(root.left);
//        if (left != null && left.val > root.val) {
//            int val = left.val;
//            left.val = root.val;
//            root.val = val;
//            return root;
//        }
//        TreeNode right = recover(root.right);
//        if (right != null && right.val < root.val) {
//            int val = right.val;
//            right.val = root.val;
//            root.val = val;
//            return root;
//        }
//        return root;
//    }
}
