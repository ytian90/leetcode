package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * GG MJ
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=297237&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * Multiple children tree encode into XML string
 * @author ytian
 *
 */
public class MultiTreeEncodeToXML {
	
	/*
	 * example:
	 *       a
	 *     / | \
	 *    b  c  d
	 *   /|  /
	 *  e f  g
	 *      /
	 *     h
	 * return: <a><b><e/><f/></b><c><g><h/></g></c><d/></a>
	 * 
	 */
	public static String recursion(Node root) {
		StringBuilder sb = new StringBuilder();
		buildString(root, sb);
		return sb.toString();
	}
	
	private static void buildString(Node root, StringBuilder sb) {
		if (root.child == null || root.child.isEmpty()) {
			sb.append("<" + root.val + "/>");
			return;
		}
		sb.append("<" + root.val + ">");
		for (int i = 0; i < root.child.size(); i++) {
			buildString(root.child.get(i), sb);
		}
		sb.append("</" + root.val + ">");
	}
	
	public static String iteration(Node root) {
		if (root == null) return "";
		StringBuilder sb = new StringBuilder();
		Stack<Node> stack = new Stack<>();
		Stack<String> res = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			if (curr.child == null || curr.child.isEmpty()) {
				sb.append("<" + curr.val + "/>");
				continue;
			}
			sb.append("<" + curr.val + ">");
			res.push("</" + curr.val + ">");
			for (int i = curr.child.size() - 1; i >= 0; i--) {
				stack.push(curr.child.get(i));
			}
		}
		while (!res.isEmpty()) {
			sb.append(res.pop());
		}
		return sb.toString();
	}
	
	public static String iterative(Node root) {
		
		return null;
	}

	public static void main(String[] args) {
		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		Node f = new Node('f');
		Node g = new Node('g');
		Node h = new Node('h');
		a.child.add(b);
		a.child.add(c);
		a.child.add(d);
		b.child.add(e);
		b.child.add(f);
		c.child.add(g);
		g.child.add(h);
		
		System.out.println(recursion(a));
		System.out.println(iteration(a));
	}
	
	public static class Node {
		char val;
		List<Node> child;
		public Node(char val) {
			this.val = val;
			this.child = new ArrayList<>();
		}
	}

}
