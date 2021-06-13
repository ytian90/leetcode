package company.lnkin;

/**
 * LC 256. Paint House
 *
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
 *
 * For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
 * Return the minimum cost to paint all houses.
 *
 * Example 1:
 *
 * Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 * Minimum cost: 2 + 5 + 3 = 10.
 * Example 2:
 *
 * Input: costs = [[7,6,2]]
 * Output: 2
 */
public class PaintHouse {

    public int minCost(int[][] costs) {
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
 * Paint House and Paint House II have the same answers, the II solution is applicable for use case I.
 */
