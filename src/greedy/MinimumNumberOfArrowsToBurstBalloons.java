package greedy;

import java.util.Arrays;

/**
 * 452. Minimum Number of Arrows to Burst Balloons
 * @author yutian
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {
	
	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length < 1) return 0;
		Arrays.sort(points, (a, b) -> (a[0] - b[0]));
		int res = 1;
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > end) {
				res++;
				end = points[i][1];
			} else {
				end = Math.min(end, points[i][1]);
			}
		}
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
