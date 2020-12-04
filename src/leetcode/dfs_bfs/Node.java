package leetcode.dfs_bfs;

import java.util.List;

/*
 * Definition of Node
 * LC 133 Clone Graph
 */
public class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {}

	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
