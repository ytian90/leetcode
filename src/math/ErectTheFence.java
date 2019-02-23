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
        Set<Point> res = new HashSet<>();
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) {
                start = points[i];
            }
        }
        res.add(start);
        Point curr = start;
        List<Point> collinearPoints = new ArrayList<>();
        do {
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == curr) {
                    continue;
                }
                int val = crossProduct(curr, nextTarget, points[i]);
                if (val > 0) {
                    nextTarget = points[i];
                    collinearPoints.clear();
                } else if (val == 0) {
                    if (distance(curr, nextTarget, points[i]) < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                }
            }
            for (Point p : collinearPoints) {
                res.add(p);
            }
            res.add(nextTarget);
            curr = nextTarget;
        } while (start != curr);
        return new ArrayList<>(res);
    }

    /**
     * Cross product to find where c belongs in reference to vector ab.
     * If result > 0 it means 'c' is on left of ab
     *    result == 0 it means 'a','b' and 'c' are collinear
     *    result < 0  it means 'c' is on right of ab
     */
    public static int crossProduct(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int x1 = a.x - b.x;
        int y2 = a.y - c.y;
        int x2 = a.x - c.x;
        return x1 * y2 - x2 * y1;
    }

    /**
     * Returns < 0 if 'b' is closer to 'a' compared to 'c', == 0 if 'b' and 'c' are same distance from 'a'
     * or > 0 if 'c' is closer to 'a' compared to 'b'.
     */
    public static int distance(Point a, Point b, Point c) {
        int y1 = a.y - b.y;
        int x1 = a.x - b.x;
        int y2 = a.y - c.y;
        int x2 = a.x - c.x;
        return Integer.compare(y1 * y1 + x1 * x1, y2 * y2 + x2 * x2);
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
