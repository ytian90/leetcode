package dfs_bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 947. Most Stones Removed with Same Row or Column
 */
public class MostStonesRemovedWithSameRowOrColumn {

    public static int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int numOfIslands = 0;
        for (int[] stone : stones) {
            if (!visited.contains(stone)) {
                dfs(stones, stone, visited);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private static void dfs(int[][] stones, int[] stone, Set<int[]> visited) {
        visited.add(stone);
        for (int[] next : stones) {
            if (!visited.contains(next)) {
                if (stone[0] == next[0] || stone[1] == next[1]) {
                    dfs(stones, next, visited);
                }
            }
        }
    }

    public static int removeStone(int[][] stones) {
        int n = stones.length;
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }
        int numIslands = n;
        for (int i = 0; i < n; i++) {
            int r1 = stones[i][0];
            int c1 = stones[i][1];
            for (int j = i + 1; j < n; j++) {
                int r2 = stones[j][0];
                int c2 = stones[j][1];
                if (r1 == r2 || c1 == c2) {
                    int x = find(map, i);
                    int y = find(map, j);
                    if (x != y) {
                        map[x] = y;
                        numIslands--;
                    }
                }
            }
        }
        return n - numIslands;
    }

    private static int find(int[] map, int i) {
        while (map[i] != i) {
            map[i] = map[map[i]];
            i = map[i];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(removeStones(new int[][]{{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}}));
        System.out.println(removeStones(new int[][]{{0, 0}}));
        System.out.println(removeStones(new int[][]{{0, 1}, {0, 2}, {4, 3}, {2, 4}, {0, 3}, {1, 1}}));
    }
}
