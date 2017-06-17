package array;
/**
 * 334. Increasing Triplet Subsequence
 * @author yutian
 * @since Feb 19, 2016
 */
public class IncreasingTripletSubsequence {
	
	// O(n) time complexity and O(1) space complexity
	public boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
        	if (n <= small) small = n;
        	else if (n <= big) big = n;
        	else return true;
        }
        return false;
    }

	public static void main(String[] args) {
		IncreasingTripletSubsequence t = new IncreasingTripletSubsequence();
		System.out.println(t.increasingTriplet(new int[]{1, 1, 1, 1})); // two <=
		System.out.println(t.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
		System.out.println(t.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
		
	}

}
