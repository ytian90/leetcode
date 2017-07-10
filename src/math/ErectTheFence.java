package math;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 587. Erect the Fence
 * @author ytian
 *
 */
public class ErectTheFence {
	
	public static List<Point> outerTrees(Point[] points) {
        List<Point> res = new ArrayList<>();
        if (points == null || points.length == 0) return res;
        Set<Point> visited = new HashSet<>();
        
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].y > start.y || (points[i].y == start.y && points[i].x < start.x)) {
                start = points[i];
            }
        }
        
        if (points.length == 1) {
            res.add(start);
            return res;
        }
        
        Point curr = start;
        while (curr != null && visited.add(curr)) {
            res.add(curr);
            for (int i = 0; i < points.length; i++) {
                if (visited.contains(points[i])) continue;
                if (isBorder(curr, points[i], points)) {
                    curr = points[i];
                    break;
                }
            }
        }
        
        for (int i = 0; i < points.length; i++) {
            if (visited.contains(points[i]) || res.contains(points[i])) continue;
            int size = res.size();
            for (int j = 0; j < size; j++) {
                Point p = res.get(j);
                if (isBorder(p, points[i], points)) {
                    visited.add(points[i]);
                    res.add(points[i]);
                    break;
                }
            }
        }
        return res;
    }
    
    private static boolean isBorder(Point p, Point q, Point[] points) {
        int dx = p.x - q.x, dy = p.y - q.y;
        int b = p.x * dy - p.y * dx;
        int prev = 0;
        for (int i = 0; i < points.length; i++) {
            int x = points[i].x;
            int y = points[i].y;
            int sign = dx * y - dy * x + b;
            if (sign == 0) continue;
            if (sign * prev < 0) return false;
            if (sign < 0) prev = -1;
            else prev = 1;
        }
        return true;
    }

	public static void main(String[] args) {
		Point[] p = new Point[]{
				new Point(1, 1),
				new Point(2, 2),
				new Point(2, 0),
				new Point(2, 4),
				new Point(3, 3),
				new Point(4, 2)
		};
		
		System.out.println(outerTrees(p));
	}

}
