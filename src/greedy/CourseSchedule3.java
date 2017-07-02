package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 630. Course Schedule III
 * @author ytian
 *
 */
public class CourseSchedule3 {
	
	public static int scheduleCourse(int[][] courses) {
        int n = courses.length;
        if (n == 0) return 0;
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int start = 0;
        for (int[] c : courses) {
        	start += c[0];
        	pq.offer(c[0]);
        	if (start > c[1]) {
        		start -= pq.poll();
        	}
        }
        return pq.size();
    }

	public static void main(String[] args) {
		int[][] t = new int[][]{
			{100, 200},
			{200, 1300},
			{1000, 1250},
			{2000, 3200}
		};
		
		System.out.println(scheduleCourse(t));
	}

}
