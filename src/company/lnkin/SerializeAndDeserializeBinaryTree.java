package company.lnkin;

import leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 297. Serialize and Deserialize Binary Tree
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *
 * Example 1:
 *        1
 *       / \
 *      2   3
 *         / \
 *        4   5
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 *
 * Input: root = [1,2]
 * Output: [1,2]
 *
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(",", list);
    }

    private void serialize(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("NULL");
            return;
        }
        list.add(node.val + "");
        serialize(node.left, list);
        serialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> strs = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(strs);
    }

    private TreeNode deserialize(LinkedList<String> list) {
        String s = list.removeFirst();
        if ("NULL".equals(s)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }
}
