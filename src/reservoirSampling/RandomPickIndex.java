package reservoirSampling;

import java.util.Random;

/**
 * 398. Random Pick Index
 * @author yutian
 *
 */
public class RandomPickIndex {
	
	int[] nums;
	Random rand;
	
	public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] != target)
        		continue;
        	if (rand.nextInt(++count) == 0)
        		result = i;
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
