package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import util.BTreePrinter;

/**
 * 449. Serialize and Deserialize BST
 * @author ytian
 *
 */
public class SerializeAndDeserializeBST {

    private static final String splitter = "/";

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(splitter);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> list = new LinkedList<>(Arrays.asList(data.split(splitter)));
        return deserialize(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static TreeNode deserialize(Queue<String> list, int lo, int hi) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int val = Integer.valueOf(list.peek());
        if (val < lo || val > hi) {
            return null;
        }
        list.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserialize(list, lo, val);
        node.right = deserialize(list, val, hi);
        return node;
    }

    /*
     * 			3
     * 		9		20
     * 			  15  23
     */
    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(23);

        n0.left = n1;
        n0.right = n2;
        n2.left = n3;
        n2.right = n4;

        String result = serialize(n0);
        System.out.println(result);

        binaryTree.TreeNode res = deserialize(result);
        BTreePrinter.printTreeNode(res);
    }
	
	private static final String SEP = ",";
    private static final String NULL = "null";
    // Encodes a tree to a single string.
    public static String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return NULL;
        //traverse it recursively if you want to, I am doing it iteratively here
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            sb.append(root.val).append(SEP);
            if (root.right != null) st.push(root.right);
            if (root.left != null) st.push(root.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    // pre-order traversal
    public static TreeNode deserialize1(String data) {
        if (data.equals(NULL)) return null;
        String[] strs = data.split(SEP);
        Queue<Integer> q = new LinkedList<>();
        for (String e : strs) {
            q.offer(Integer.parseInt(e));
        }
        return getNode(q);
    }
    
    // some notes:
    //   5
    //  3 6
    // 2   7
    private static TreeNode getNode(Queue<Integer> q) { //q: 5,3,2,6,7
        if (q.isEmpty()) return null;
        TreeNode root = new TreeNode(q.poll());//root (5)
        Queue<Integer> samllerQueue = new LinkedList<>();
        while (!q.isEmpty() && q.peek() < root.val) {
            samllerQueue.offer(q.poll());
        }
        //smallerQueue : 3,2   storing elements smaller than 5 (root)
        root.left = getNode(samllerQueue);
        //q: 6,7   storing elements bigger than 5 (root)
        root.right = getNode(q);
        return root;
    }
}
