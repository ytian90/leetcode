package leetcode.hashtable;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. Smallest Range
 * @author ytian
 *
 */
public class SmallestRange {
	
	public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
        	max = Math.max(max, nums.get(i).get(0));
        	pq.add(new int[]{nums.get(i).get(0), i, 0}); // val, index, row
        }
        int[] res = {pq.peek()[0], max};
        while (res[1] - res[0] != 0 && pq.peek()[2] + 1 < nums.get(pq.peek()[1]).size()) {
        	int[] curr = pq.poll();
        	pq.add(new int[]{nums.get(curr[1]).get(curr[2] + 1), curr[1], curr[2] + 1});
        	max = Math.max(max, nums.get(curr[1]).get(curr[2] + 1));
        	if (max - pq.peek()[0] < res[1] - res[0]) res = new int[]{pq.peek()[0], max};
        }
        return res;
    }

	public static void main(String[] args) {
		List<List<Integer>> t = 
				Arrays.asList(Arrays.asList(4, 10, 15, 24, 26),
							  Arrays.asList(0, 9, 12, 20),
							  Arrays.asList(5, 18, 22, 30));
		
		System.out.println(Arrays.toString(smallestRange(t)));
	}

}
