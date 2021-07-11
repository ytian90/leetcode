package company.lnkin.mj;

/**
 * LC 547. Number of Provinces
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 * Example 1:
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 * Example 2:
 *
 *
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, res = 0;
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int x = find(root, i);
                    int y = find(root, j);
                    if (root[x] != root[y]) {
                        root[x] = y;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (root[i] == i) {
                res++;
            }
        }
        return res;
    }

    private int find(int[] root, int i) {
        while (i != root[i]) {
            i = root[i];
            root[i] = root[root[i]];
        }
        return i;
    }
}
