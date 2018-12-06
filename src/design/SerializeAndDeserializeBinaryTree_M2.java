package design;

import binaryTree.TreeNode;
import util.BTreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Use BFS
 */
public class SerializeAndDeserializeBinaryTree_M2 {
    // BFS
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                sb.append("n ");
                continue;
            }
            sb.append(curr.val + " ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode curr = q.poll();
            if (!values[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                curr.left = left;
                q.add(left);
            }
            i++;
            if (!values[i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                curr.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);

        n0.left = n1;
        n0.right = n2;
        n2.left = n3;
        n2.right = n4;

        String result = serialize(n0);
        System.out.println(result);

        binaryTree.TreeNode res = deserialize(result);
        BTreePrinter.printTreeNode(res);
    }
}
