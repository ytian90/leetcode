package company.lnkin;

/**
 * LC 265. Paint House II
 *
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Return the minimum cost to paint all houses.
 *
 * Example 1:
 *
 * Input: costs = [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation:
 * Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 * Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Example 2:
 *
 * Input: costs = [[1,3],[2,4]]
 * Output: 5
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int min1 = 0, min2 = 0, index = -1;
        for (int i = 0; i < costs.length; i++) {
            int m1 = Integer.MAX_VALUE / 2, m2 = m1, idx = -1;
            for (int j = 0; j < costs[i].length; j++) {
                int cost = costs[i][j] + (j == index ? min2 : min1);
                if (cost < m1) {
                    m2 = m1;
                    m1 = cost;
                    idx = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1;
            min2 = m2;
            index = idx;
        }
        return min1;
    }
}

/**
 * since house[i] and house[i - 1] cannot have the same color, we should choose 2nd min color
 * min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n
 * since current row only relies on last row for getting mins and avoid same color, O(1) space is enough.
 */
