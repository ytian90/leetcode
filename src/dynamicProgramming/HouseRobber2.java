package dynamicProgramming;
/**
 * 213. House Robber II
 * @author yutian
 * @since Aug 5, 2015
 */
public class HouseRobber2 {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    public static int rob(int[] nums, int lo, int hi) {
        int rob = 0, noRob = 0;
        for (int i = lo; i <= hi; i++) {
            int t = noRob;
            noRob = Math.max(rob, noRob);
            rob = t + nums[i];
        }
        return Math.max(rob, noRob);
    }
	// method 1 time ~O(2N), space ~O(2N)
	public static int rob0(int[] nums) {
		int n = nums.length;
        if (nums == null || n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);  
        // include 1st element, and not last element
        int[] d = new int[n];
        // not include first element, and include last element        
        int[] m = new int[n];
        d[0] = 0; m[0] = 0;
        d[1] = nums[0];
        m[1] = nums[1];
        for (int i = 2; i < n; i++) {
        	d[i] = Math.max(d[i - 1], d[i - 2] + nums[i - 1]);
        	m[i] = Math.max(m[i - 1], m[i - 2] + nums[i]);
        }
        return Math.max(d[n - 1], m[n - 1]);
    }
	
	// method 1 time ~O(2N), space ~O(1)
	public int rob2(int[] nums) {
		int n = nums.length;
        if (nums == null || n == 0) return 0;
        if (n == 1) return nums[0];
        int pre1 = 0, cur1 = 0;
        for (int i = 0; i < n - 1; i++) { // avoid last one
        	int t = pre1;
        	pre1 = cur1;
        	cur1 = Math.max(t + nums[i], pre1);
        }
        int pre2 = 0, cur2 = 0;
        for (int i = 1; i < n; i++) { // avoid first one
        	int t = pre2;
        	pre2 = cur2;
        	cur2 = Math.max(t + nums[i], pre2);
        }
        return Math.max(cur1, cur2);
	}
	
	
	public static void main(String[] args) {
//		System.out.println(rob(new int[]{3, 4, 2}));
//		System.out.println(rob(new int[]{3, 3}));
//		System.out.println(rob(new int[]{2, 3, 5, 3}));
//		System.out.println(rob(new int[]{3}));
//		System.out.println(rob(new int[]{}));
//		System.out.println(rob(new int[]{3, 4, 2, 5, 6, 3, 10}));
		System.out.println(rob(new int[]{1, 1, 2, 1}));
	}
}
