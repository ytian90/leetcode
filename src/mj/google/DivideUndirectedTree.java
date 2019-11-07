package mj.google;

import java.util.Arrays;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=568132&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D9%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 * 一个undirected tree，然后从中间截断，两边node相等，问在哪儿截断。
 */
public class DivideUndirectedTree {
    public static int[] removeEdge(int N, int[][] edges) {
        if (N % 2 != 0) {
            throw new IllegalArgumentException();
        }
        int[] map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = i;
        }
        int count = 1;
        int target = -1;
        for (int[] e : edges) {
            int x = find(map, e[0]);
            int y = find(map, e[1]);
            if (target != -1 && (x == target || y == target)) {
                return new int[]{e[0], e[1]};
            }
            if (x != y) {
                count++;
                map[x] = y;
                if (2 * count == N) {
                    target = y;
                }
            }
        }
        return new int[]{-1, -1};
    }

    private static int find(int[] map, int i) {
        while (map[i] != i) {
            map[i] = map[map[i]];
            i = map[i];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeEdge(6, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}})));
        System.out.println(Arrays.toString(removeEdge(8, new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}, {4, 6}, {4, 7}})));
        System.out.println(Arrays.toString(removeEdge(8, new int[][]{{0, 1}, {0, 2}, {0, 3}, {4, 5}, {4, 6}, {4, 7}, {2, 4}})));
    }
}
