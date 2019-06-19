package bitManipulation;
/**
 * 476. Number Complement
 * @author ytian
 *
 */
public class NumberComplement {

	// 100110, its complement is 011001, the sum is 111111. So we only need maxPerformance the min number large or equal
	// to num, then do substraction
	public static int findComplement(int num) {
		int i = 0, j = 0;
		while (i < num) {
			i += Math.pow(2, j);
			j++;
		}
		return i - num;
	}
	
	/*
	 * input: 5, output: 2
	 * 5 is 101, to maxPerformance the mask, use highestOneBit to maxPerformance 100, left shift, 1000,
	 * minus 1, maxPerformance 111, & with the negative number to maxPerformance the flip result
	 */
	public static int findComplements(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

	public static void main(String[] args) {
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
		System.out.println(findComplement(100));
	}

}
