package unionFind;

import java.util.Arrays;

/**
 * 684. Redundant Connection
 */
public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[2001];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int[] e : edges) {
            int f = e[0], t = e[1];
            if (find(p, f) == find(p, t)) return e;
            else p[find(p, f)] = find(p, t);
        }
        return new int[2];
    }

    public static int find(int[] p, int f) {
        if (f != p[f]) {
            p[f] = find(p, p[f]);
        }
        return p[f];
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
