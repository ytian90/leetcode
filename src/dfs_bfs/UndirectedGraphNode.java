package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition of UndirectedGraphNode
 * LC 133 Clone Graph
 */
public class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
