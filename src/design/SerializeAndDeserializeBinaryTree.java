package design;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * Serialize and Deserialize Binary Tree
 * @author yutian
 * @since Dec 19, 2015
 */
public class SerializeAndDeserializeBinaryTree {

	private static final String splitter = "/";
	private static final String nn = "null";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode root, StringBuilder sb) {
    	if (root == null) sb.append(nn).append(splitter);
    	else {
    		sb.append(root.val).append(splitter);
    		buildString(root.left, sb);
    		buildString(root.right, sb);
    	}
	}

	// Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(splitter)));
        return buildTree(nodes);
    }

	private static TreeNode buildTree(List<String> nodes) {
		String val = nodes.remove(0);
		if (val.equals(nn)) return null;
		else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = buildTree(nodes);
			node.right = buildTree(nodes);
			return node;
		}
		
	}
	

	
	/*
	 * 			3
	 * 		9		20	
	 * 			  15  7
	 */
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
		
		TreeNode res = deserialize(result);
		showTree(res);
	}
	
	private static void showTree(TreeNode node) {
		if (node == null) {
			System.out.println("null");
			return;
		}
		System.out.println(node.val);
		showTree(node.left);
		showTree(node.right);
	}
	

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.deserialize(codec.serialize(root));
	
	 // Definition for a binary tree node.
	 public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
}
