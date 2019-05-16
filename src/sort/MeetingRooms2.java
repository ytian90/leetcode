package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 * @author yutian
 * @since Jan 6, 2016
 */
public class MeetingRooms2 {
	
	// min heap, average time complexity O(nlogn)
	// Time Complexity - O(nlogn)， Space Complexity - O(n)
	public static int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
        	return 0;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a, b) -> a.end - b.end);
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
			// get the meeting room that finishes earliest
			Interval curr = pq.poll();
			if (curr.end <= intervals[i].start) {
				// if the current meeting starts right after, no need for new room, merge
				curr.end = intervals[i].end;
			} else {
				// otherwise, this meeting needs a new room
				pq.offer(intervals[i]);
			}
			// don't forget to put the meeting room back
			pq.offer(curr);
		}
        return pq.size();
    }

    // new interface with int[][] intervals
	public int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(intervals.length, (a, b) -> a[1] - b[1]);
		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		pq.offer(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			int[] curr = pq.poll();
			if (curr[1] <= intervals[i][0]) {
				curr[1] = intervals[i][1];
			} else {
				pq.offer(intervals[i]);
			}
			pq.offer(curr);
		}
		return pq.size();
	}
	
	public static int minMeetingRooms2(Interval[] intervals) {
//		int max = Arrays.stream(intervals).max((a, b) -> a.end - b.end).get().end;
		int max = 0;
        for(Interval i : intervals){
            max = Math.max(max, i.end);
        }
		int[] count = new int[max + 1];
		for (Interval i : intervals) {
			count[i.start]++;
			count[i.end]--;
		}
		int maxRoom = 0;
		int total = 0;
		for (int n : count) {
			total += n;
			maxRoom = Math.max(maxRoom, total);
		}
		return maxRoom;
	}

	public static void main(String[] args) {
		Interval[] test = new Interval[3];
		test[0] = new Interval(9, 10);
		test[1] = new Interval(4, 9);
		test[2] = new Interval(4, 17);
		System.out.println(minMeetingRooms2(test));
	}

}
