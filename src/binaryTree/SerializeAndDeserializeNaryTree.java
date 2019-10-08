package binaryTree;

import java.util.*;

/**
 * 428. Serialize and Deserialize N-ary Tree
 */
public class SerializeAndDeserializeNaryTree {
    private static final String splitter = "/";

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private static void serialize(Node root,  StringBuilder sb) {
        if (root == null) {
            return;
        }
        int size = root.children.size();
        sb.append(root.val).append(splitter).append(size).append(splitter);
        for (Node node : root.children) {
            serialize(node, sb);
        }
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> list = new LinkedList<>(Arrays.asList(data.split(splitter)));
        return deserialize(list);
    }

    private static Node deserialize(Queue<String> list) {
        int val = Integer.valueOf(list.poll());
        int size = Integer.valueOf(list.poll());
        Node root = new Node(val, new ArrayList<>());
        for (int i = 0; i < size; i++) {
            root.children.add(deserialize(list));
        }
        return root;
    }

    public static void main(String[] args) {
        Node n0 = new Node(1, new ArrayList<>());
        n0.children.add(new Node(3, new ArrayList<>()));
        n0.children.add(new Node(2, new ArrayList<>()));
        n0.children.add(new Node(4, new ArrayList<>()));
        n0.children.get(0).children.add(new Node(5, new ArrayList<>()));
        n0.children.get(0).children.add(new Node(6, new ArrayList<>()));

        String res = serialize(n0);
        System.out.println(res);
        Node n1 = deserialize(res);
        System.out.println(serialize(n1));
    }

    // Encodes a tree to a single string.
    public static String serialize1(Node root) {
        if (root == null) {
            return null;
        }
        List<String> res = new ArrayList<>();
        convertTreeToString(root, res);
        return String.join(",", res);
    }

    private static void convertTreeToString(Node root, List<String> res) {
        if (root == null) {
            return;
        }
        res.add(String.valueOf(root.val));
        res.add(String.valueOf(root.children.size()));
        for (Node child : root.children) {
            convertTreeToString(child, res);
        }
    }

    // Decodes your encoded data to tree.
    public static Node deserialize1(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        Queue<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return convertStringToTree(list);
    }

    private static Node convertStringToTree(Queue<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Node root = new Node();
        root.val = Integer.valueOf(list.poll());
        int size = Integer.valueOf(list.poll());
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(convertStringToTree(list));
        }
        return root;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            this.val = _val;
            this.children = _children;
        }
    }

}
