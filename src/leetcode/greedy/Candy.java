package leetcode.greedy;

import java.util.Arrays;

/**
 * Candy
 * @author yutian
 * @since Nov 9, 2015
 */
public class Candy {
	
	// Time ~O(3N), Space ~O(N)
	// Greedy
	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] candyNum = new int[n];
		Arrays.fill(candyNum, 1);
		
		for (int i = 1; i < n; ++i) {
			if (ratings[i - 1] < ratings[i]) { // ascending
				candyNum[i] = candyNum[i - 1] + 1;
			}
		}
		
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
				candyNum[i] = candyNum[i + 1] + 1;
			}
		}
		
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += candyNum[i];
		}
		return total;
	}

	public static void main(String[] args) {
		int[] r = new int []{4, 2, 3, 4, 1};
		System.out.println(candy(r));
	}

}
