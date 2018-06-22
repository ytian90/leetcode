package array;
/**
 * 485. Max Consecutive Ones
 * @author ytian
 *
 */
public class MaxConsecutiveOnes {
	
	public static int findMaxConsecutiveOnes(int[] nums) {
        int maxSoFar = 0, max = 0;
        for (int n : nums) {
        	if (n == 0) maxSoFar = 0;
        	else maxSoFar++;
        	max = Math.max(max, maxSoFar);
        }
        return max;
    }

	public static void main(String[] args) {
		int[] test1 = {1, 1, 0, 1, 1, 1};
		int[] test2 = {1, 1, 0, 1, 1, 0};
		System.out.println(findMaxConsecutiveOnes(test1));
		System.out.println(findMaxConsecutiveOnes(test2));

	}

}
