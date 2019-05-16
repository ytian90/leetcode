package array;

import java.util.Random;

/**
 * Randomly return the index of maximal elements in the array
 * linear time and constant space
 * http://www.1point3acres.com/bbs/thread-120864-1-1.html
 * @author yutian
 * @since Jan 31, 2016
 */
public class GenerateRandomMaxIndex {
	
	public static int randomMax(int[] A) {
		if (A == null || A.length == 0)
			throw new IllegalArgumentException();
		Random rand = new Random();
		int res = 0, max = Integer.MIN_VALUE, count = 0;
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
				res = i;
				count = 1;
			} else if (max == A[i]) {
				count++;
				int idx = rand.nextInt(count); // (0, sort - 1)
				if (idx == 0) res = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 3, 3, 3, 1, 2};
        System.out.println(randomMax(nums));
        int[] counter = new int[nums.length];
        for(int i = 0; i < 1000; i++){
        	int idx = randomMax(nums);
        	counter[idx]++;
        }
        for(int i = 0; i < nums.length; i++){
        	System.out.println(i + " " + counter[i]);
        }
	}

}

