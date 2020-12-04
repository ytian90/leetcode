package leetcode.bitManipulation;
/**
 * 342. Power of Four
 * @author yutian
 * @since May 8, 2016
 */
public class PowerOfFour {

	public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
	
	public static void main(String[] args) {
		PowerOfFour t = new PowerOfFour();
		System.out.println(t.isPowerOfFour(5));
	}
	
	/*
	 * First, Any number passes "n^(n-1)==0" must be powers of 2. 
	 * Second, all numbers above could be further categorized to 
	 * 2 class. A: all numbers that are 2^(2k+1) and 
	 * B: all numbers that 2^(2k). Third, we could show that 
	 * 2^(2k+1)-1 could not pass the test of (n-1)%3==0. 
	 * (by induction) So all A are ruled out, leaving only B, 
	 * which is power of 4.
	 */

}
