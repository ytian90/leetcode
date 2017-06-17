package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. Next Greater Element II
 * @author ytian
 *
 */
public class NextGreaterElement2 {
	
	public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length, res[] = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i ++) {
        	int num  = nums[i % n];
        	while (!stack.isEmpty() && nums[stack.peek()] < num) {
        		res[stack.pop()] = num;
        	}
        	if (i < n) stack.push(i);
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
	}

}
