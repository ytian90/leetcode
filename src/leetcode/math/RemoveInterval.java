package leetcode.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1272. Remove Interval
 */
public class RemoveInterval {
    public static List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] <= toBeRemoved[0] || intervals[i][0] >= toBeRemoved[1]) {
                res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                if (intervals[i][0] < toBeRemoved[0]) {
                    res.add(Arrays.asList(intervals[i][0], toBeRemoved[0]));
                }
                if (toBeRemoved[1] < intervals[i][1]) {
                    res.add(Arrays.asList(toBeRemoved[1], intervals[i][1]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeInterval(new int[][]{{0, 2}, {3, 4}, {5, 7}}, new int[]{1, 6})); // [[0, 1], [6, 7]]
        System.out.println(removeInterval(new int[][]{{0, 5}}, new int[]{2, 3})); // [[0, 2], [3, 5]]
        System.out.println(removeInterval(new int[][]{{-5, -4}, {-3, -2}, {1, 2}, {3, 5}, {8, 9}}, new int[]{-1, 4})); // [[-5,-4],[-3,-2],[4,5],[8,9]]
    }
}
