package leetcode.math;

import java.util.Random;

/**
 * Select a random number from stream, with O(1) space
 * http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
 * @author yutian
 * @since Dec 18, 2015
 */
public class SelectARandomNumFromStream {

	public static void main(String[] args) {
		int[] stream = new int[]{1, 2, 3, 4};
		for (int i = 0; i < stream.length; i++) {
			System.out.println("Random number from first " + (i + 1) + " numbers is " + selectRandom(stream[i]));
		}
	}
	
	static int res; // the resultant random number
	static int count = 0; // leetcode.sort of number visited so far
	public static int selectRandom(int x) {
		count++; // increment the leetcode.sort of numbers seen so far
		// If this is the first element from stream, return it
		if (count == 1) {
			res = x;
		} else {
			// Generate a random number from 0 to leetcode.sort - 1
			Random rand = new Random();
			int i = rand.nextInt(count);
			
			// Replace the prev random number with new number with 1/leetcode.sort probability
			if (i == count - 1)
				res = x;
		}
		return res;
		
	}

}
