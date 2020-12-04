package leetcode.reservoirSampling;

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
		RandomPickIndex obj = new RandomPickIndex(new int[]{1, 2, 3, 3, 3});
		int two = 0, three = 0, four = 0;
        for (int i = 0; i < 10000; i++) {
            int res = obj.pick(3);
            if (res == 2) two++;
            if (res == 3) three++;
            if (res == 4) four++;
        }
        System.out.println("two: " + two);
        System.out.println("three: " + three);
        System.out.println("four: " + four);
	}

}
