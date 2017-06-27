package array;
/**
 * 581. Shortest Unsorted Continuous Subarray
 * @author ytian
 *
 */
public class ShortestUnsortedContinuousSubarray {
	
	/*
	 * start & end to keep track of minimum subarray A[start...end], which must be sorted for the entire array A to be
	 * sorted. If end < start < 0 at the end of the for loop, then the array is already fully sorted.
	 */
	public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, start = -1, end = -2, min = nums[n - 1], max = nums[0];
        for (int i = 1; i < n; i++) {
        	max = Math.max(max, nums[i]); // from left to right, search the current max
        	min = Math.min(min, nums[n - 1 - i]); // from right to left, search the current min
        	if (nums[i] < max) end = i;
        	if (nums[n - 1 - i] > min) start = n - 1 - i;
        }
        return end - start + 1;
    }

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
	}

}
