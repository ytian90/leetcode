package leetcode.binarySearch;
/**
 * 154. Find Minimum in Rotated Sorted Array II
 * @author yutian
 * @since Sep 9, 2015
 */
public class FindMinimumInSortedRotatedArray2 {
	public static int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
            		lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
            		hi = mid;
            } else {
                hi--;
            }
        }
        return nums[lo];
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{1})); 
		System.out.println(findMin(new int[]{3, 1, 1, 2})); 
		System.out.println(findMin(new int[]{3, 3, 1})); 
		System.out.println(findMin(new int[]{1, 1, 3})); 
		System.out.println(findMin(new int[]{3, 5, 5, 1, 1})); 
	}
}
