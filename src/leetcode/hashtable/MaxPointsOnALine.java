package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * @author yutian
 * @since Nov 9, 2015
 */
public class MaxPointsOnALine {

	public static int maxPoints(Point[] points) {
		if (points == null) return 0;
		if (points.length <= 2) return points.length;

		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			Point p = points[i];
			int overlap = 0, max = 0;
			for (int j = i + 1; j < points.length; j++) {
				Point q = points[j];
				int x = q.x - p.x;
				int y = q.y - p.y;
				if (x == 0 && y == 0) {
					overlap++;
					continue;
				}
				int gcd = generateGCD(x, y);
				if (gcd != 0) {
					x /= gcd;
					y /= gcd;
				}

				if (map.containsKey(x)) {
					map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
				} else {
					Map<Integer, Integer> m = new HashMap<>();
					m.put(y, 1);
					map.put(x, m);
				}
				max = Math.max(max, map.get(x).get(y));
			}
			res = Math.max(res, max + overlap + 1);
		}
		return res;
	}

	public static int generateGCD(int a, int b) {
		if (b == 0) return a;
		return generateGCD(b, a % b);
	}

	public static void main(String[] args) {
		Point[] points = new Point[9];
		points[0] = new Point(84, 250);
		points[1] = new Point(0, 0);
		points[2] = new Point(1, 0);
		points[3] = new Point(0, -70);
		points[4] = new Point(0, -70);
		points[5] = new Point(1, -1);
		points[6] = new Point(21, 10);
		points[7] = new Point(42, 90);
		points[8] = new Point(-42, -230);
		System.out.println(maxPoints(points));

		// method 2 is not working for this use case
		Point[] points2 = new Point[3];
		points2[0] = new Point(0, 0);
		points2[1] = new Point(94911151,94911150);
		points2[2] = new Point(94911152,94911151);
		System.out.println(maxPoints(points2));
	}

	// Definition for a point
	static class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}

	// Time ~ O(N^2), Space ~ O(N)
	public static int maxPoints2(Point[] points) {
		int max = 0;
		for (int i = 0; i < points.length; i++) {
			Point pt = points[i];
			// max number of neighbor points on the same line (exclude the same point)
			int pointMax = 0;
			// number of same points (exclude the point itself)
			int samePoint = 0; 
			// <slope, number of neighbor points>
			Map<Double, Integer> map = new HashMap<>();
			for (int j = i + 1; j < points.length; j++) {
				Point neighbor = points[j];
				if (pt.x == neighbor.x && pt.y == neighbor.y) {
					samePoint++;
				} else {
					double s = slope(pt, neighbor);
					map.put(s, map.getOrDefault(s, 0) + 1);
					pointMax = Math.max(pointMax, map.get(s));
				}
			}
			max = Math.max(max, pointMax + samePoint); // 1 -> pt
		}
		return max;
	}

	private static double slope(Point a, Point b) {
		if (a.x == b.x) return Double.POSITIVE_INFINITY;
		// to avoid the error due to the difference between +0.0 and -0.0
		if (a.y == b.y) return 0; 
		// need to convert to double first
		return (double) (a.y - b.y) / (double) (a.x - b.x);
	}


}
