package leetcode.dfs_bfs;

import java.util.*;

/**
 * 133. Clone leetcode.graph
 * @author yutian
 * @since Jul 29, 2015
 */
public class CloneGraph {
	
	// Solution 1: Depth-first traversal: recursive
    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        return helper(node, map);
    }

    private static Node helper(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copyNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, copyNode);
        for (Node n : node.neighbors) {
            copyNode.neighbors.add(helper(n, map));
        }
        return copyNode;
    }
    
    public static void main(String[] args) {
    	CloneGraph z = new CloneGraph();
    	Node n0 = new Node();
    	n0.val = 0;
    	Node n1 = new Node();
    	n1.val = 1;
    	Node n2 = new Node();
    	n2.val = 2;
    	n0.neighbors.add(n1);
    	n0.neighbors.add(n2);
    	n1.neighbors.add(n2);
    	n2.neighbors.add(n2);
    	
    	Node r = z.cloneGraph(n0);
    	System.out.print(Integer.valueOf(r.val) + " # ");
		for (Node t: r.neighbors) {
			System.out.print(t.val + " ");
		}
		System.out.println();
    	for (Node u: r.neighbors) {
    		System.out.print(Integer.valueOf(u.val) + " # ");
    		for (Node t: u.neighbors) {
    			System.out.print(t.val + " ");
    		}
    		System.out.println();
    	}
    }
	
	// Solution 2: Breadth-first traversal
	public Node cloneGraph2(Node node) {
		if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copy = new Node();
        copy.val = node.val;
        map.put(node, copy);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (map.containsKey(n)) {
                    map.get(curr).neighbors.add(map.get(n));
                } else {
                    Node nc = new Node();
                    nc.val = n.val;
                    map.get(curr).neighbors.add(nc);
                    map.put(n, nc);
                    q.add(n);
                }
            }
        }
        return copy;
    }
	
	// Solution 3: DFS iterative
	public Node cloneGraph3(Node node) {
		if (node == null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        Map<Node, Node> map = new HashMap<>();
        Node t = new Node();
        t.val = node.val;
        map.put(node, t);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    t = new Node();
                    t.val = n.val;
                    map.put(n, t);
                    stack.push(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
	}
}
