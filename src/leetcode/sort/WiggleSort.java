package leetcode.sort;
/**
 * 280. Wiggle Sort
 * @author yutian
 * @since Dec 27, 2015
 */
public class WiggleSort {
	
	public static void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int a = nums[i - 1];
			if ((a > nums[i]) == (i % 2 == 1)) {
				nums[i - 1] = nums[i];
				nums[i] = a;
			}
		}
	}
	
	public static void wiggleSort2(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			int a = nums[i - 1];
			if ((a > nums[i]) && (i % 2 == 1)) {
				nums[i - 1] = nums[i];
				nums[i] = a;
			} else if ((a < nums[i]) && (i % 2 == 0)) {
				nums[i - 1] = nums[i];
				nums[i] = a;
			}
		}
	}

	public static void main(String[] args) {
		int[] t = new int[]{3, 5, 2, 1, 6, 4};
		wiggleSort(t);
		for (int i: t) {
			System.out.print(i + " ");
		}
	}

}
