package company.uuba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 56. Merge Interval
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end < intervals[i][0]) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[]{start, end});
        int[][] r = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            r[i] = res.get(i);
        }
        return r;
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}
