package leetcode.array;

import java.util.Arrays;
import java.util.Random;

/**
 * 384. Shuffle an Array
 * @author yutian
 * @since Aug 30, 2016
 */
public class ShuffleAnArray {
	
	private int[] nums;
	private Random random;
	
	public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
	
	/** Resets the leetcode.array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the leetcode.array. */
    public int[] shuffle() {
        if (nums == null) return null;
        int[] a = nums.clone();
        for (int j = 1; j < a.length; j++) {
        	int i = random.nextInt(j + 1);
        	swap(a, i, j);
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
    	int t = a[i];
    	a[i] = a[j];
    	a[j] = t;
    }

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		ShuffleAnArray obj = new ShuffleAnArray(nums);
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
        System.out.println(Arrays.toString(param_1));
        System.out.println(Arrays.toString(param_2));
	}

}
