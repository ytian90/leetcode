package company.uber;

import java.util.Arrays;

/**
 * LC 757. Set Intersection Size At Least Two
 *
 * An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.
 *
 * Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has a size of at least two.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[1,4],[2,5],[3,5]]
 * Output: 3
 * Explanation: Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
 * Also, there isn't a smaller size set that fulfills the above condition.
 * Thus, we output the size of this set, which is 3.
 * Example 2:
 *
 * Input: intervals = [[1,2],[2,3],[2,4],[4,5]]
 * Output: 5
 * Explanation: An example of a minimum sized set is {1, 2, 3, 4, 5}.
 *
 *
 * Constraints:
 *
 * 1 <= intervals.length <= 3000
 * intervals[i].length == 2
 * 0 <= ai < bi <= 108
 */
public class SetIntersectionSizeAtLeastTwo {
    public static int intersectionSizeTwo(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) {
            return res;
        }
        Arrays.sort(intervals, (a, b) -> a[1] != b[1] ? a[1] - b[1] : b[0] - a[0]);
        int left = intervals[0][1] - 1;
        int right = intervals[0][1];
        res += 2;
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // One element of the set is in the interval, use the overlap one and most rightest one
            if (left < curr[0] && curr[0] <= right) {
                res++;
                left = right;
                right = curr[1];
            // No element of the set is in the interval, pick the most rightest two.
            } else if (curr[0] > right) {
                res += 2;
                left = curr[1] - 1;
                right = curr[1];
            }
        }
        return res;
    }

    /**
     * Time: O(NlogN)
     * Space: O(1)
     */



    public static void main(String[] args) {
        System.out.println(intersectionSizeTwo(new int[][]{
                {1, 3}, {1, 4}, {2, 5}, {3, 5}
        }));
        System.out.println(intersectionSizeTwo(new int[][]{
                {33, 44}, {42, 43}, {13, 37}, {24, 33}, {24, 33},
                {25, 48}, {10, 47}, {18, 24}, {29, 37}, {7, 34}
        }));
    }
}
