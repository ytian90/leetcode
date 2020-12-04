package leetcode.mj.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * lc296
 */
public class BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return getMin(rows) + getMin(cols);
    }

    private static int getMin(List<Integer> list) {
        int res = 0;
        Collections.sort(list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
        System.out.println(minTotalDistance(test));
    }
}
