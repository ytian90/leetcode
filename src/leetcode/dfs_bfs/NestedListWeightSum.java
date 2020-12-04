package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 339. Nested List Weight Sum
 * @author yutian
 * @since Apr 8, 2016
 */
public class NestedListWeightSum {
	
	// Method 1: DFS time ~O(N) space ~O(N)
	public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
	
	private int helper(List<NestedInteger> list, int depth) {
		int res = 0;
        for (NestedInteger n : list) {
        	if (n.isInteger()) {
        		res += n.getInteger() * depth;
        	} else {
        		res += helper(n.getList(), depth + 1);
        	}
        }
        return res;
	}
	
	// Method 2: Queue time ~O(N) space ~O(N)
	public int depthSum2(List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
		int res = 0, depth = 1;
		Queue<NestedInteger> q = new LinkedList<>(nestedList);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				NestedInteger n = q.poll();
				if (n.isInteger()) {
					res += n.getInteger() * depth;
				} else {
					q.addAll(n.getList());
				}
			}
			depth++;
		}
		return res;
	}
	
	public static void main(String[] args) {

	}
	
	// This is the interface that allows for creating nested lists.
	// You should not implement it, or speculate about its implementation
	public interface NestedInteger {
		// @return true if this NestedInteger holds a single integer, rather than a nested list.
		public boolean isInteger();
		 
		// @return the single integer that this NestedInteger holds, if it holds a single integer
		// Return null if this NestedInteger holds a nested list
		public Integer getInteger();
		 
		// @return the nested list that this NestedInteger holds, if it holds a nested list
		// Return null if this NestedInteger holds a single integer
		public List<NestedInteger> getList();
	}

}
