package company.uuba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 305. Number of Islands II
 *
 * You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).
 *
 * We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.
 *
 * Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * Initially, the 2d grid is filled with water.
 * - Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
 * - Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
 * - Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
 * - Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.
 * Example 2:
 *
 * Input: m = 1, n = 1, positions = [[0,0]]
 * Output: [1]
 */
public class NumberOfIslandsII {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[] root = new int[m * n];
        Arrays.fill(root, -1);
        for (int[] p : positions) {
            int i = n * p[0] + p[1];
            if (root[i] != -1) {
                res.add(count);
                continue;
            }
            root[i] = i;
            count++;
            for (int[] d : dirs) {
                int x = p[0] + d[0], y = p[1] + d[1];
                int j = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || root[j] == -1) {
                    continue;
                }
                int r = find(root, j);
                if (i != r) {
                    root[i] = r;
                    i = r;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private static int find(int[] root, int i) {
        while (root[i] != i) {
            i = root[i];
            root[i] = root[root[i]];
        }
        return i;
    }

    /**
     * To represent a list of islands, we use trees. i.e., a list of roots. This helps us find the identifier of an
     * island faster. If roots[c] = p means the parent of node c is p, we can climb up the parent chain to find out
     * the identifier of an island, i.e., which island this point belongs to:
     *
     * Do root[root[roots[c]]]... until root[c] == c;
     * To transform the two dimension problem into the classic UF, perform a linear mapping:
     *
     * int id = n * x + y;
     * Initially assume every cell are in non-island set {-1}. When point A is added, we create a new root,
     * i.e., a new island. Then, check if any of its 4 neighbors belong to the same island.
     * If not, union the neighbor by setting the root to be the same. Remember to skip non-island cells.
     *
     * UNION operation is only changing the root parent so the running time is O(1).
     *
     * FIND operation is proportional to the depth of the tree. If N is the number of points added,
     * the average running time is O(logN), and a sequence of 4N operations take O(NlogN).
     * If there is no balancing, the worse case could be O(N^2).
     *
     * Remember that one island could have different roots[node] value for each node.
     * Because roots[node] is the parent of the node, not the highest root of the island.
     * To find the actually root, we have to climb up the tree by calling findIsland function.
     *
     * Time: O(N ^ 2)
     * Space: O(N)
     *
     */

    public static void main(String[] args) {
        System.out.println(numIslands2(3, 3, new int[][]{
                {0,0}, {0,1}, {1,2}, {1,2}
        }));
        System.out.println(numIslands2(3, 3, new int[][]{
                {0,1}, {1,2}, {2,1}, {1,0}, {0,2}, {0,0}, {1,1}
        }));
    }
}
