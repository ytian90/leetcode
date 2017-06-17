package dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 * Clone graph
 * @author yutian
 * @since Jul 29, 2015
 */
public class CloneGraph {
	
	// Solution 1: Depth-first traversal: recursive
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    UndirectedGraphNode helper(UndirectedGraphNode node, 
    		Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        for (UndirectedGraphNode n: node.neighbors) {
            copy.neighbors.add(helper(n, map));
        }
        return copy;
    }
    
    public static void main(String[] args) {
    	CloneGraph z = new CloneGraph();
    	UndirectedGraphNode n0 = new UndirectedGraphNode(0);
    	UndirectedGraphNode n1 = new UndirectedGraphNode(1);
    	UndirectedGraphNode n2 = new UndirectedGraphNode(2);
    	n0.neighbors.add(n1);
    	n0.neighbors.add(n2);
    	n1.neighbors.add(n2);
    	n2.neighbors.add(n2);
    	
    	UndirectedGraphNode r = z.cloneGraph(n0);
    	System.out.print(Integer.valueOf(r.label) + " # ");
		for (UndirectedGraphNode t: r.neighbors) {
			System.out.print(t.label + " ");
		}
		System.out.println();
    	for (UndirectedGraphNode u: r.neighbors) {
    		System.out.print(Integer.valueOf(u.label) + " # ");
    		for (UndirectedGraphNode t: u.neighbors) {
    			System.out.print(t.label + " ");
    		}
    		System.out.println();
    	}
    }
	
	// Solution 2: Breadth-first traversal
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        while (!q.isEmpty()) {
            UndirectedGraphNode curr = q.poll();
            for (UndirectedGraphNode n : curr.neighbors) {
                if (map.containsKey(n)) {
                    map.get(curr).neighbors.add(map.get(n));
                } else {
                    UndirectedGraphNode nc = new UndirectedGraphNode(n.label);
                    map.get(curr).neighbors.add(nc);
                    map.put(n, nc);
                    q.add(n);
                }
            }
        }
        return copy;
    }
	
	// Solution 3: DFS iterative
	public UndirectedGraphNode cloneGraph3(UndirectedGraphNode node) {
		if (node == null) return null;
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        while (!stack.isEmpty()) {
            UndirectedGraphNode curr = stack.pop();
            for (UndirectedGraphNode n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new UndirectedGraphNode(n.label));
                    stack.push(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
	}
}
