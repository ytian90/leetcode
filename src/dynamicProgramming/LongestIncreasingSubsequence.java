package dynamicProgramming;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * @author yutian
 * @since Jan 3, 2016
 */
public class LongestIncreasingSubsequence {
	
	// Solution 1: DP O(N^2)
	public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] d = new int[len];
        Arrays.fill(d, 1);
        int result = 1;
        for (int i = 1; i < len; i++) {
	        	for (int j = 0; j < i; j++) {
	        		if (nums[j] < nums[i]) {
	        			d[i] = Math.max(d[i], d[j] + 1);
	        		}
	        	}
	        	result = Math.max(result, d[i]);
        }
        return result;
    }

	public static void main(String[] args) {
		int[] test = new int[]{ 10,9,2,5,3,7,101,18 };
		System.out.println(lengthOfLIS2(test));
	}

	// Solution 2: Binary search O(NlongN)
	public static int lengthOfLIS2(int[] nums) {
		int[] d = new int[nums.length];
		int len = 0;
		for (int x : nums) {
			// index of the search key, if it is contained 
			// in the array within the specified range; 
			// otherwise, (-(insertion point) - 1).
			int i = Arrays.binarySearch(d, 0, len, x);
			if (i < 0) i = -(i + 1);
			d[i] = x;
			if (i == len) len++;
		}
		return len;
	}
	
	// Solution 3
	public static int lengthOfLIS3(int[] nums) {
		int size = nums.length;
		int[] tailTable = new int[size];
		int len; // always points empty slot
		tailTable[0] = nums[0];
		len = 1;
		for (int i = 1; i < size; i++) {
			if (nums[i] < tailTable[0]) { 
				// new smallest value
				tailTable[0] = nums[i];
			} else if (nums[i] > tailTable[len - 1]) { 
				// nums[i] wants to extend largest subsequence
				tailTable[len++] = nums[i];
			} else {
				// nums[i] wants to be current and candidate of an existing
				// subsequence. It will replace ceil value in TailTable
				tailTable[CeilIndex(tailTable, 0, len, nums[i])] = nums[i];
			}
		}
		return len;
	}
	
	private static int CeilIndex(int[] A, int l, int r, int key) {
        while (l < r) {
            int m = l + (r - l) / 2;
            if (key <= A[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }



}
