package string;
/**
 * 553. Optimal Division
 * @author ytian
 *
 */
public class OptimalDivision {
	
	public static String optimalDivision(int[] nums) {
        if (nums.length == 1) {
        	return nums[0] + "";
        }
        if (nums.length == 2) {
        	return nums[0] + "/" + nums[1];
        }
        String res = nums[0] + "/(" + nums[1];
        for (int i = 2; i < nums.length; i++) {
        	res += "/" + nums[i];
        }
        return res + ")";
    }

	public static void main(String[] args) {
		System.out.println(optimalDivision(new int[]{1000,100,10,2}));
	}

}
