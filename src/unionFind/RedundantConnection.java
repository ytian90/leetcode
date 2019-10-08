package unionFind;

import java.util.Arrays;

/**
 * 684. Redundant Connection
 */
public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[]{-1, -1};
        }
        int n = edges.length;
        int[] nums = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            nums[i] = i;
        }
        for (int[] e : edges) {
            int x = find(nums, e[0]);
            int y = find(nums, e[1]);
            if (x == y) {
                return new int[]{e[0], e[1]};
            }
            nums[x] = y;
        }
        return new int[]{-1, -1};
    }

    private static int find(int[] nums, int i) {
        if (nums[i] == i) {
            return i;
        }
        return find(nums, nums[i]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        })));
    }
}
