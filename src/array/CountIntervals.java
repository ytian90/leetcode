package array;
/**
 * Count Intervals, Print Invervals
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=165664&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Jan 14, 2016
 */
public class CountIntervals {
	
	// output 
	public static void getIntervals(int[] nums, int interval) {
		int len = nums.length, count = 0;
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
			if ((i + 1) % interval == 0) {
				System.out.println(); 
				count++;
			}
		}
		if (len % count != 0) count++;
		System.out.println("\nNumber of intervals: " + count);
	}
	
	// save to 2d array
	public static int[][] getIntervals2(int[] nums, int interval) {
		int M = (nums.length % interval == 0) ? nums.length / interval: nums.length / interval + 1;
		int N = interval;
		int[][] result = new int[M][N];
		for (int i = 0; i < nums.length; i++) {
			result[i / interval][i % interval] = nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = new int[]{1,2,3,6,7,9,13,14};
		getIntervals(test, 3);
		int[][] test2 = getIntervals2(test, 3);
		for (int[] e: test2) {
			for (int x: e) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}

}
