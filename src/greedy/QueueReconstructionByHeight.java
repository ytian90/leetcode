package greedy;

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
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> res = new LinkedList<>();
        for (int[] p : people) {
        	res.add(p[1], p); // insert person in the list based on # of people in front of him or her
        }
        return res.toArray(new int[0][0]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		for (int[] a : reconstructQueue(test)) {
			System.out.println(a[0] + " " + a[1]);
		}

	}

}
