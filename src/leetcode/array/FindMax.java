package leetcode.array;
/**
 * https://shawnlincoding.wordpress.com/2015/04/11/find-max/
 * find the maximum number in an integer leetcode.array.
 * The numbers in the leetcode.array increase first, then decreases.
 * Maybe there’s only increase or decrease
 * @author yutian
 *
 */
public class FindMax {
	
	public int findMax(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException();
		}
		// length 1
		if (array.length == 1) {
			return array[0];
		}
		// length 2
		if (array.length == 2) {
			return (array[0] > array[1]) ? array[0] : array[1];
		}
		int start = 0, end = array.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			// rise tendency
			if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1] ) {
				start = mid;
			// max
			} else if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
				return array[mid];
			// fall tendency
			} else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
				end = mid;
			}
		}
		return (array[start] > array[end]) ? array[start] : array[end];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
        int[] nums1 = {1, 2};
        int[] nums2 = {1, 3, 2};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums4 = {7, 6, 5, 4, 3, 2, 1};
        int[] nums5 = {1, 2, 3, 4, 5, 6, 8, 7, 4};
        FindMax ins = new FindMax();
        System.out.println(ins.findMax(nums));
        System.out.println(ins.findMax(nums1));
        System.out.println(ins.findMax(nums2));
        System.out.println(ins.findMax(nums3));
        System.out.println(ins.findMax(nums4));
        System.out.println(ins.findMax(nums5));

	}

}
