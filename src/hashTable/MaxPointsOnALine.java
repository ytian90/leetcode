package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Points on a Line
 * @author yutian
 * @since Nov 9, 2015
 */
public class MaxPointsOnALine {
	
	// Definition for a point
	class Point {
		int x;
		int y;
		Point() { x = 0; y = 0; }
		Point(int a, int b) { x = a; y = b; }
	}
	
	// Time ~ O(N^2), Space ~ O(N)
	public int maxPoints(Point[] points) {
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
			max = Math.max(max, pointMax + samePoint + 1); // 1 -> pt
		}
		return max;
	}

	private double slope(Point a, Point b) {
		if (a.x == b.x) return Double.POSITIVE_INFINITY;
		// to avoid the error due to the difference between +0.0 and -0.0
		if (a.y == b.y) return 0; 
		// need to convert to double first
		return (double) (a.y - b.y) / (double) (a.x - b.x); 
	}

	public static void main(String[] args) {

	}

}
