package divideAndConquer;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * The Skyline Problem
 * @author yutian
 * @since Dec 6, 2015
 */
public class TheSkylineProblem {
	// Heap + BST
	public static List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<>();
		PriorityQueue<Point> points = new PriorityQueue<>(new Comparator<Point>(){
			public int compare(Point a, Point b) {
				if (a.x != b.x) {
					return a.x - b.x;
				}
				return a.y - b.y;
			}
		});
		TreeMap<Integer, Integer> heights = new TreeMap<>();
		for (int[] b : buildings) {
			points.add(new Point(b[0], -b[2])); // start point, use negative to keep y decr order
			points.add(new Point(b[1], b[2])); // end point
		}
		heights.put(0, 1);
		int prevHeight = 0;
		while (!points.isEmpty()) {
			Point point = points.poll();
			if (point.y < 0) {
				heights.put(-point.y, heights.getOrDefault(-point.y, 0) + 1);
			} else {
				heights.put(point.y, heights.get(point.y) - 1);
				if (heights.get(point.y) == 0) heights.remove(point.y);
			}
			int currHeight = heights.lastKey();
			if (currHeight != prevHeight) {
				res.add(new int[]{point.x, currHeight});
				prevHeight = currHeight;
			}
		}
		return res;
    }
	
	// Divide and Conquer
	public static List<int[]> getSkyline2(int[][] buildings) {
		return helper(buildings, 0, buildings.length - 1);
	}

	private static ArrayList<int[]> helper(int[][] buildings, int lo, int hi) {
		ArrayList<int[]> result = new ArrayList<>();
		if (lo > hi) return result;
		if (lo == hi) {
			result.add(new int[] {buildings[lo][0], buildings[lo][2]});
			result.add(new int[] {buildings[lo][1], 0});
			return result;
		}
		int mid = (lo + hi) / 2;
		ArrayList<int[]> left = helper(buildings, lo, mid);
		ArrayList<int[]> right = helper(buildings, mid + 1, hi);
		int leftMax = 0, rightMax = 0, max = 0;
		for (int i = 0, j = 0; i < left.size() || j < right.size(); ) {
			int currentMax = 0;
			if (i < left.size() && j < right.size() && left.get(i)[0] == right.get(j)[0]) {
				leftMax = left.get(i)[1];
				rightMax = right.get(j)[1];
				currentMax = Math.max(leftMax, rightMax);
				if (currentMax != max) {
					result.add(new int[] {left.get(i)[0], currentMax});
					max = currentMax;
				}
				i++;
				j++;
			}
			else if (j >= right.size() || i < left.size() && j < right.size() && left.get(i)[0] < right.get(j)[0]) {
				leftMax = left.get(i)[1];
				currentMax = Math.max(leftMax, rightMax);
				if (currentMax != max) {
					result.add(new int[] {left.get(i)[0], currentMax});
					max = currentMax;
				}
				i++;
			} else if (j >= left.size() || i < left.size() && j < right.size() && left.get(i)[0] > right.get(j)[0]) {
				rightMax = right.get(j)[1];
				currentMax = Math.max(leftMax, rightMax);
				if (currentMax != max) {
					result.add(new int[] { right.get(j)[0], currentMax});
					max = currentMax;
				}
				j++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] test1 = new int[][]{{1, 2, 1}, {1, 2, 2}, {1, 2, 3}, {1, 2, 4}, {2, 3, 2}, {2, 3, 4}};
		List<int[]> ans1 = new ArrayList<>();
		ans1 = getSkyline2(test1);
		for (int[] a : ans1) {
			for (int i : a) {
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

}
