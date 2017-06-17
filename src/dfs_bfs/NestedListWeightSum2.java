package dfs_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 364. Nested List Weight Sum II
 * @author yutian
 * @since Jul 3, 2016
 */
public class NestedListWeightSum2 {
	
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	// Use Weighted Factor
	public int depthSumInverse(List<NestedInteger> nestedList) {
        int prev = 0, res = 0;
        while (!nestedList.isEmpty()) {
        	List<NestedInteger> next = new ArrayList<>();
        	for (NestedInteger n : nestedList) {
        		if (n.isInteger()) 
        			prev += n.getInteger();
        		else 
        			next.addAll(n.getList());
        	}
        	res += prev;
        	nestedList = next;
        }
        return res;
    }
	
	// BFS
	public int depthSumInverse2(List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
        LinkedList<NestedInteger> q = new LinkedList<>(nestedList);
        int prev = 0, res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = q.poll();
                if (n.isInteger()) prev += n.getInteger();
                else {
                	q.addAll(n.getList());                
                }
            }
            res += prev;
        }
        return res;
	}
	
	// DFS
	public int depthSumInverse3(List<NestedInteger> nestedList) {
		List<Integer> list = new ArrayList<>();
		for (NestedInteger target : nestedList) {
			helper(list, 1, target);
		}
		System.out.println(list);
		int res = 0;
		for (int i = 0; i < list.size(); i++) {
			res += list.get(i) * (list.size() - i);
		}
		return res;
	}
	

	private void helper(List<Integer> list, int level, NestedInteger target) {
		if (target.isInteger()) {
			for (int i = list.size(); i < level; i++) {
				list.add(0);
			}
			list.set(level - 1, list.get(level - 1) + target.getInteger());
		} else {
			for (NestedInteger t : target.getList()) {
				helper(list, level + 1, t);
			}
		}
	}

	public static void main(String[] args) {

	}

}
