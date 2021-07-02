package company.uuba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LC 759. Employee Free Time
 *
 * We are given a list schedule of employees, which represents the working time for each employee.
 *
 * Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.
 *
 * Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.
 *
 * (Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.
 *
 * Example 1:
 *
 * Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 * Explanation: There are a total of three employees, and all common
 * free time intervals would be [-inf, 1], [3, 4], [10, inf].
 * We discard any intervals that contain inf as they aren't finite.
 * Example 2:
 *
 * Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
 * Output: [[5,6],[7,9]]
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> time = new ArrayList<>();
        for (List<Interval> s : schedule) {
            time.addAll(s);
        }
        Collections.sort(time, (a, b) -> (a.start - b.start));
        int start = time.get(0).start, end = time.get(0).end;
        for (int i = 1; i < time.size(); i++) {
            if (end < time.get(i).start) {
                res.add(new Interval(end, time.get(i).start));
                start = time.get(i).start;
                end = time.get(i).end;
            } else {
                end = Math.max(end, time.get(i).end);
            }
        }
        return res;
    }

    /**
     * Time: O(NlogN)
     * Space: O(N)
     */

    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    };
}
