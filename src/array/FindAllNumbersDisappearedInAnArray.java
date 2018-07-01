package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * @author ytian
 *
 */
public class FindAllNumbersDisappearedInAnArray {

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int n : nums) {
			int t = Math.abs(n) - 1;
			if (nums[t] > 0) {
				nums[t] = -nums[t];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res.add(i + 1);
			}
		}
		return res;
    }

	public static void main(String[] args) {
		int[] test = new int[]{4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(test));
	}
	
	/*
	 * Iterate through the input array and mark elements as negative 
	 * using nums[nums[i] - 1] = -nums[nums[i] - 1].  In this way all 
	 * the numbers that we have seen will be marked as negative. 
	 * In the second iteration, if a value is not marked as negative, 
	 * it implies we have never seen that index before, so just add 
	 * it to the return list.
	 */

}
