package array;

import java.util.Random;

/**
 * Reservoir Sampling
 * http://www.geeksforgeeks.org/reservoir-sampling/
 * @author yutian
 * @since Jan 5, 2016
 */
public class ReservoirSampling {
	
	/*
	 * 1) Create an array reservoir[0..k-1] and copy first k items of stream[] to it.
	   2) Now one by one consider all items from (k+1)th item to nth item.
		…a) Generate a random number from 0 to i where i is index of current item in stream[]. 
			Let the generated random number is j.
		…b) If j is in range 0 to k-1, replace reservoir[j] with arr[i]
	 */
	
	public static void selectKItems(int[] stream, int n, int k) {
		int[] reservoir = new int[k];
		Random rand = new Random();
		// save first k elements into result
		for (int i = 0; i < k; i++) {
			reservoir[i] = stream[i];
		}
		// random pick j from (1, i) if 0 < j < k, swap
		for (int i = k; i < n; i++) {
			int j = rand.nextInt(i + 1);
			if (j < k) reservoir[j] = stream[i];
		}
		for (int i: reservoir) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		selectKItems(test, 12, 5);
	}

}
