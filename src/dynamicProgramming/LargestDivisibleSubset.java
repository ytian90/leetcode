package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. Largest Divisible Subset
 * @author yutian
 * @since Jul 2, 2016
 */
public class LargestDivisibleSubset {
	
	public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums); 
        for (int i = nums.length - 1; i >= 0; i--) {
        	List<Integer> l = new ArrayList<>();
        	l.add(nums[i]);
        	for (int j = i - 1; j >= 0; j--) {
        		if (l.get(l.size() - 1) % nums[j] == 0) {
        			l.add(nums[j]);
        		}
        	}
        	if (l.size() > res.size()) {
        		res = l;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] t1 = new int[]{1, 2, 3};
		int[] t2 = new int[]{1, 2, 4, 8};
		System.out.println(largestDivisibleSubset(t1));
		System.out.println(largestDivisibleSubset(t2));
	}

}
