package sort;

import java.util.Arrays;

/**
 * Maximum Gap
 * @author yutian
 * @since Nov 9, 2015
 */
public class MaximumGap {

	// Bucket Sort: Time ~O(2N), Space ~O(2N)
	public static int maximumGap(int[] nums) {
		int n = nums.length;
		if (n < 2) return 0;
		
		// find the max and min
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		if (max == min) return 0;
		
		// create n - 1 buckets with their own min and max values
		// there must be at least one is empty
		int numBucket = n - 1;
		int sizeBucket = (int) Math.ceil((double) (max - min) / numBucket);
		int[] maxBucket = new int[numBucket];
		int[] minBucket = new int[numBucket];
		Arrays.fill(maxBucket, Integer.MIN_VALUE);
		Arrays.fill(minBucket, Integer.MAX_VALUE);
		
		// put n - 2 numbers (except max and min) into n - 1 buckets
		// by updating the corresponding bucket's min and max value
		for (int i = 0; i < n; i++) {
			if (nums[i] != max && nums[i] != min) {
				int index = (nums[i] - min) / sizeBucket;
				maxBucket[index] = Math.max(maxBucket[index], nums[i]);
				minBucket[index] = Math.min(minBucket[index], nums[i]);
			}
		}
		// find the max gap
		int maxGap = Integer.MIN_VALUE, prev = min;
		for (int i = 0; i < numBucket; i++) {
			if (maxBucket[i] != Integer.MIN_VALUE && minBucket[i] != Integer.MAX_VALUE) {
				maxGap = Math.max(maxGap, minBucket[i] - prev);
				prev = maxBucket[i];
			}
		}
		maxGap = Math.max(maxGap, max - prev);
		return maxGap;
	}
	
	public static void main(String[] args) {
		int[] test1 = new int[]{2, 5, 1};
		System.out.println(maximumGap(test1));
	}

}
