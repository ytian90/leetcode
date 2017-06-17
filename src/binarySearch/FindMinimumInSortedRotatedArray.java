package binarySearch;
/**
 * Find Minimum in Sorted Rotated Array
 * @author yutian
 * @since Aug 1, 2015
 */
public class FindMinimumInSortedRotatedArray {
	public static int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
            	lo = mid + 1;
            } else {
            	hi = mid;
            }
        }
        return nums[lo];
	}
	
	public static void main(String[] args) {
		System.out.println(findMin(new int[]{3, 1, 2})); 
		System.out.println(findMin(new int[]{3, 1})); 
		System.out.println(findMin(new int[]{1, 3})); 
		System.out.println(findMin(new int[]{3, 5, 1})); 
	}
}
