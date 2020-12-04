package leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 406. Queue Reconstruction by Height
 * @author yutian
 *
 */
public class QueueReconstructionByHeight {
	
	public static int[][] reconstructQueue(int[][] people) {
		// decrease by height, increase by # of people in front of this person
		List<int[]> list = new LinkedList<>();
		Arrays.sort(people, (a, b) -> {
			if (a[0] != b[0]) {
				return b[0] - a[0];
			}
			return a[1] - b[1];
		});
		for (int[] p : people) {
			list.add(p[1], p);
		}
		return list.toArray(new int[0][0]);
    }

	public static void main(String[] args) {
		int[][] test = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		for (int[] a : reconstructQueue(test)) {
			System.out.println(a[0] + " " + a[1]);
		}
	}

}
