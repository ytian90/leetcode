package sort;

import java.util.Arrays;

/**
 * 324. Wiggle Sort 2
 * @author yutian
 * @since Jan 16, 2016
 */
public class WiggleSort2 {
	
	// Time ~O(NlogN) Space ~O(N)
	public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1: n / 2;
        int[] temp = Arrays.copyOf(nums, n);
        int index = 0;
        for (int i = 0; i <= mid; i++) {
        	nums[index] = temp[mid - i];
        	if (index + 1 < n) {
        		nums[index + 1] = temp[n - i - 1];
        	}
        	index += 2;
        }
    }

	public static void main(String[] args) {
		int[] t1 = new int[]{6, 13, 5, 4, 5, 2};
		wiggleSort(t1);
		System.out.println(Arrays.toString(t1));
	}
	
	public void wiggleSort2(int[] nums) {
		int median = getMedian(nums);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;
        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
	}
	
	private static int getMedian(int[] numArray) {
		Arrays.sort(numArray);
		int median;
		if (numArray.length % 2 == 0)
		    median = (numArray[numArray.length/2] + numArray[numArray.length/2 - 1])/2;
		else
		    median = numArray[numArray.length/2];
		return median;
	}
	
	private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
	
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	}
	
//	public static void wiggleSort2(int[] nums) {
//		int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1: n / 2;
//		int[] temp = Arrays.copyOf(nums, n);
//		int i = 0, j = 0, k = n - 1;
//		while (j <= k) {
//			if (nums[j] > mid) {
//				swap(nums, i, j);
//				i++; j++;
//			} else if (nums[j] < mid) {
//				swap(nums, j, k);
//				k--;
//			} else {
//				j++;
//			}
//		}
//	}
//	
//	private static void swap(int[] a, int i, int j) {
//        int t = a[i];
//	    a[i] = a[j];
//	    a[j] = t;
//	}


}
