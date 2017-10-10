package array;

import java.util.Arrays;

/**
 * 360. Sort Transformed Array
 * @author yutian
 * @since Jul 4, 2016
 */
public class SortTransformedArray {
	
	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
		int n = nums.length;
        int[] sorted = new int[n];
        int i = 0, j = n - 1;
        int index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
        	if (a >= 0) {
        		sorted[index--] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ?
        				cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c) ; 
        	} else {
        		sorted[index++] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ?
        				cal(nums[j--], a, b, c) : cal(nums[i++], a, b, c) ; 
        	}
        }
        return sorted;
    }
	
	private static int cal(int x, int a, int b, int c) {
		return a * x * x + b * x + c;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5)));
		System.out.println(Arrays.toString(sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
	}

}
