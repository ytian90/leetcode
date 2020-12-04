package leetcode.bitManipulation;
/**
 * Single Number II
 * @author yutian
 * @since Jul 28, 2015
 */
public class SingleNumber2 {
	// Solution 1: to use an leetcode.array of size 32 to keep track of the total leetcode.sort of ith bit.
	int singleNumber(int A[]) {
		int count[] = new int[32];
		int n = A.length;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < n; j++) {
				if (((A[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= ((count[i] % 3) << i);
		}
		return result;
	}
	// Solution 2: to use three bitmask variables
	int singleNumber2(int[] nums) {
		int ones = 0, twos = 0, threes = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			twos |= ones & nums[i]; // appear twice, add into twos
			ones ^= nums[i]; // delete twice items from ones
			threes = ones & twos; // if three times, they will appear both in ones and twos
			ones &= ~threes; // delete three times items from ones
			twos &= ~threes; // delete three times items from twos
			
			/*
			 * b |= a&A[i];  //出现两次的 就加到B里面
			 * a ^= A[i];    //从A里面删除 出现两次的
			 * c = ~(a&b);   //如果是三次的 就会同时出现在A和B里面， 
			 * a &= c;       //然后删除A里三次的
			 * b &= c;       //删除B里三次的
			 */
		}
		return ones;
	}
}
