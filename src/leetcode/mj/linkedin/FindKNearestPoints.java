package leetcode.mj.linkedin;

import java.util.*;

/**
 给定一个中心点，然后找到K个nearest points
 */
public class FindKNearestPoints {
    class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // solution 1: priority queue
    public List<Point> findKCloestPoints(Point[] points, int k, Point point) {
        List<Point> res = new ArrayList<>();
        if (points == null || points.length == 0 || k <= 0) {
            return res;
        }
        PriorityQueue<Point> maxDistance = new PriorityQueue<>(k, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int dist1 = distance(o1, point);
                int dist2 = distance(o2, point);
                return dist2 - dist1;
            }
        });
        for (Point p : points) {
            maxDistance.add(p);
            if (maxDistance.size() > k) {
                maxDistance.poll();
            }
        }
        res.addAll(maxDistance);
        return res;
    }

    public int distance(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    // solution 2: quick select
    public List<Point> findNesrestKthPoint(Point[] points, int k, Point point) {
        List<Point> res = new ArrayList<>();
        if (points.length == 0 || k < 1 || k > points.length)
            return res;
        int lo = 0, hi = points.length - 1;
        while (true) {
            int pos = partition(points, lo, hi, point);
            if (pos == k - 1) break;
            else if (pos > k - 1) hi = pos - 1;
            else lo = pos + 1;
        }
        res.addAll(Arrays.asList(points));
        return res;
    }

    private int partition(Point[] points, int lo, int hi, Point point) {
        int index = lo;
        Point pivot = points[index];
        int distance = distance(pivot, point);
        swap(points, index, hi);
        for (int i = lo; i < hi; i++) {
            int curr = distance(points[i], point);
            if (curr < distance) swap(points, i, index++);
        }
        swap(points, index, hi);
        return index;
    }

    private void swap(Point[] points, int i, int j) {
        Point t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

}
