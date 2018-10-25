package dfs_bfs;

import java.util.HashMap;
import java.util.Map;

/**
 * 533. Lonely Pixel 2
 */
public class LonelyPixel2 {

    public int findBlackPixel(char[][] picture, int N) {
        int n = picture.length;
        if (n == 0) return 0;
        int m = picture[0].length;
        if (m == 0) return 0;

        Map<String, Integer> map = new HashMap<>();
        int[] colCount = new int[m];

        for (int i = 0; i < n; i++) {
            String key = scanRow(picture, i, N, colCount);
            if (key.length() != 0) {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int res = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < m; j++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        res += N;
                    }
                }
            }
        }

        return res;
    }

    private String scanRow(char[][] picture, int row, int target, int[] colCount) {
        int n = picture[0].length;
        int rowCount = 0;
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }

        if (rowCount == target) return sb.toString();
        return "";
    }
}
