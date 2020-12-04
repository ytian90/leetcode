package leetcode.dynamicProgramming;
/**
 * 265. Paint House 2
 * @author yutian
 * @since Dec 28, 2015
 */
public class PaintHouse2 {
	
	/*
	 * We can use min1 and min2 to track the indices of the 1st and 2nd 
	 * smallest cost till previous house, if the current color's index 
	 * is same as min1, then we have to go with min2, otherwise we can 
	 * safely go with min1.
	 */
	public static int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0) return 0;
		int min1 = 0, min2 = 0, pos = -1;
		for (int i = 0; i < costs.length; i++) {
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, index = -1;
			for (int j = 0; j < costs[0].length; j++) {
				int cost = costs[i][j] + (j != pos ? min1 : min2);
				if (cost < m1) { // cost < m1 < m2
					m2 = m1; m1 = cost; index = j;
				} else if (cost < m2) { // m1 < cost < m2
					m2 = cost;
				}
			}
			min1 = m1; min2 = m2; pos = index;
		}
		return min1;
	}
	
	public static void main(String[] args) {
		int[][] test = new int[][]{{2, 1, 3, 2}, {3, 4, 2, 2}, {4, 2, 4, 5}, {2, 1, 4, 3}};
		System.out.println(minCostII(test));
	}
	
	// O(nk) runtime
	public static int minCostII2(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
        	int last1 = min1, last2 = min2;
        	min1 = min2 = -1;
        	for (int j = 0; j < k; j++) {
        		if (j != last1) { // not the last min
        			costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
        		} else {
        			costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
        		}
        		
        		// find the indices of 1st and 2st smallest cost of painting current house i
        		if (min1 < 0 || costs[i][j] < costs[i][min1]) {
        			min2 = min1; min1 = j;
        		} else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
        			min2 = j;
        		}
        	}
        }
        return costs[n - 1][min1];
    }
}
