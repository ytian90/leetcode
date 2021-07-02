package company.uuba;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LC 253. Meeting Rooms II
 *
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 */
public class MeetingRoomII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a[0] - b [0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = pq.poll();
            if (curr[1] <= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                pq.add(intervals[i]);
            }
            pq.add(curr);
        }
        return pq.size();
    }

    /**
     * When we encounter an ending event, that means that some meeting that started earlier
     * has ended now. We are not concerned with which meeting has ended. All we need is that
     * some meeting ended thus making a room available.
     * @param intervals
     * @return
     */
    public int minMeetingRooms2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startPointer = 0, endPointer = 0;
        int usedRooms = 0;
        while (startPointer < n) {
            if (start[startPointer] >= end[endPointer]) {
                usedRooms--;
                endPointer++;
            }
            usedRooms++;
            startPointer++;
        }
        return usedRooms;
    }

    /**
     * Time: O(N * logN)
     * Space: O(N)
     */
}
