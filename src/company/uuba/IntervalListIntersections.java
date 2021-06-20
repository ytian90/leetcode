package company.uuba;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LC 986. Interval List Intersections
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 * Example 1:
 *
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Example 2:
 *
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 * Example 3:
 *
 * Input: firstList = [], secondList = [[4,8],[10,12]]
 * Output: []
 * Example 4:
 *
 * Input: firstList = [[1,7]], secondList = [[3,10]]
 * Output: [[3,7]]
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i], b = secondList[j];
            if (a[1] < b[0]) {
                i++;
            } else if (b[1] < a[0]) {
                j++;
            } else {
                list.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
                if (a[1] < b[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        int k = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            res[k++] = (int[]) iterator.next();
        }
        return res;
    }
    /**
     * Time: O(N + M) N is firstList size and M is secondList size
     * Space: O(Math.min(N, M))
     */
}
