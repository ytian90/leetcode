package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 310. Minimum Height Trees
 * @author yutian
 * @since Jan 16, 2016
 */
public class MinimumHeightTrees {
	// Time ~O(N), Space ~O(N)
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj =  new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] e: edges) {
        	adj.get(e[0]).add(e[1]);
        	adj.get(e[1]).add(e[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        	if (adj.get(i).size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
        	n -= leaves.size();
        	List<Integer> newLeaves = new ArrayList<>();
        	for (int i: leaves) {
        		int j = adj.get(i).iterator().next();
        		adj.get(j).remove(i);
        		if (adj.get(j).size() == 1) newLeaves.add(j);
        	}
        	leaves = newLeaves;
        }
        return leaves;
    }

	public static void main(String[] args) {
		int[][] e1 = new int[][]{{1, 0}, {1, 2}, {1, 3}};
		int[][] e2 = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		System.out.println(findMinHeightTrees(4, e1));
		System.out.println(findMinHeightTrees(6, e2));
	}

}
