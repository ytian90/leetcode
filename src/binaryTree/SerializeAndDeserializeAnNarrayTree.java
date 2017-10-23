package binaryTree;

import java.util.ArrayList;

/**
 * GG MJ
 * Serialize and Deserialize an N-ary Tree
 * https://instant.1point3acres.com/thread/204403
 * http://www.geeksforgeeks.org/serialize-deserialize-n-ary-tree/
 * 
 * @author ytian
 *
 */
public class SerializeAndDeserializeAnNarrayTree {
	
	private static final Character MARKER = ')';

	public static void main(String[] args) {
		Node n1 = new Node('A');
		Node n2 = new Node('B');
		Node n3 = new Node('C');
		Node n4 = new Node('D');
		Node n5 = new Node('E');
		Node n6 = new Node('F');
		Node n7 = new Node('G');
		Node n8 = new Node('H');
		Node n9 = new Node('I');
		Node n10 = new Node('J');
		Node n11 = new Node('K');
		n1.child.add(n2);
		n1.child.add(n3);
		n1.child.add(n4);
		n2.child.add(n5);
		n2.child.add(n6);
		n4.child.add(n7);
		n4.child.add(n8);
		n4.child.add(n9);
		n4.child.add(n10);
		n6.child.add(n11);
		
//		print(n1, 0);
		System.out.println(serialize(n1)); // ABE)FK)))C)DG)H)I)J)))
		System.out.println();
		Node ans = deserialize("ABE)FK)))C)DG)H)I)J)))");
		System.out.println();
		print(ans, 0);
		
	}
	
	
	public static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		h1(root, sb);
		return sb.toString();
	}
	
	private static void h1(Node root, StringBuilder sb) {
		if (root == null) return;
		sb.append(root.key);
		for (int i = 0; i < root.child.size(); i++) {
			h1(root.child.get(i), sb);
		}
		sb.append(MARKER);
	}
	
	public static Node deserialize(String str) {
		Node node = new Node(str.charAt(0));
		return h2(node, str, 1);
	}
	
	private static Node h2(Node prev, String str, int pos) {
		char val = str.charAt(pos);
		if (val != MARKER) {
			Node node = new Node(val);
			prev.child.add(node);
			h2(node, str, pos + 1);
		}
		return null;
	}
	

	public static void print(Node node, int pos) {
		if (node == null) return;
		for (int i = 0; i < pos; i++) {
			System.out.print("-");
		}
		System.out.print(node.key);
		System.out.println();
		for (int i = 0; i < node.child.size(); i++) {
			print(node.child.get(i), pos + 1);
		}
	}
	
	public static class Node {
		char key;
		ArrayList<Node> child;
		public Node(char c) {
			this.key = c;
			child = new ArrayList<>();
		}
	}

}
