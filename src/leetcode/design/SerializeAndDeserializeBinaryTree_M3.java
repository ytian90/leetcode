package leetcode.design;

import leetcode.binaryTree.TreeNode;
import leetcode.util.BTreePrinter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Use Iterative DFS
 */
public class SerializeAndDeserializeBinaryTree_M3 {

    private String delimiter = ",";

    // Encodes a tree to a single leetcode.string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        TreeNode n = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                sb.append(n.val + " ");
                stack.push(n);
                n = n.left;
            } else {
                sb.append("n ");
                n = stack.pop();
                n = n.right;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data.length() == 0 || data == null)
            return null;
        String[] values = data.split(" ");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(-1);
        TreeNode curr = dummy;
        for (String s: values) {
            TreeNode next = null;
            if (s.equals("n")) {
                next = null;
            } else {
                next = new TreeNode(Integer.parseInt(s));
            }
            if (curr != null) {
                curr.left = next;
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr.right = next;
                curr = curr.right;
            }
        }
        return dummy.left;
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

        leetcode.binaryTree.TreeNode res = deserialize(result);
        BTreePrinter.printTreeNode(res);
    }

}
