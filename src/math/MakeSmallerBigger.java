package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given 2 numbers, make smaller to be bigger by swap digits in it.
 * @author yutian
 * @since Jan 23, 2016
 */
public class MakeSmallerBigger {
	
	public static int make(int A, int B) {
		if (A > B) return make(B, A);
		char[] a = String.valueOf(A).toCharArray();
		char[] b = String.valueOf(B).toCharArray();
		if (b.length > a.length) return -1;
		for (int i = 0, j = a.length - 1; i < a.length; i++) {
			if (a[i] == b[i]) continue;
			while (j > i) {
				if (a[j] > b[i]) {
					char temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
				j--;
			}
		}
		int result = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			result = result * 10 + Character.getNumericValue(a[i]);
		}
		return result;
	}
	
//	public static int solve(int A, int B) {
//		if (A > B) return make(B, A);
//		char[] a = String.valueOf(A).toCharArray();
//		char[] b = String.valueOf(B).toCharArray();
//		if (b.length > a.length) return -1;
//		int i = 0;
//		while (i < a.length && a[i] == b[i]) i++;
//		int[] map = new int[10];
//		for (int k = i; k < a.length; k++) {
//			map[a[k] - '0']++;
//		}
//		
//	}
	
	public static void main(String[] args) {
		System.out.println(make(2, 2));
		System.out.println(make(23, 2));
		System.out.println(make(2, 23));
		System.out.println(make(234, 242));
		System.out.println(make(234, 212));
		System.out.println(make(44567, 45672));
	}
	
	

//	public static int getPermutation(int A) {
//		int n = 1, div = 1;
//		while (A / div > 10) {
//			n++;
//			div *= 10;
//		}
//		int[] nums = new int[n];
//		for (int i = n - 1, t = A; i >= 0; i--) {
//			nums[i] = t % 10;
//			t /= 10;
//		}
//		int temp;
//		
//	}
	
	public static void nextPermutation(int[] nums) {
        int curr = nums.length - 1;
        while (curr > 0 && nums[curr - 1] >= nums[curr]) {
            curr--;
        }
        reverse(nums, curr, nums.length - 1);
        if (curr > 0) {
            int next = curr;
            curr--;
            while (nums[curr] >= nums[next]) next++;
            swap(nums, curr, next);
        }
    }
    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
