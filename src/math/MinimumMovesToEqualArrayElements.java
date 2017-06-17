package math;

/**
 * 453. Minimum Moves to Equal Array Elements
 * @author yutian
 *
 */
public class MinimumMovesToEqualArrayElements {
	
	public static int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int min = nums[0];
        for (int n : nums) min = Math.min(min, n);
        int res = 0;
        for (int n : nums) res += n - min;
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1, 2, 3};
		int[] nums2 = new int[]{2, 2, 3, 5};
		System.out.println(minMoves(nums));
		System.out.println(minMoves(nums2));
		
	}

}
