package bitManipulation;
/**
 * 476. Number Complement
 * @author ytian
 *
 */
public class NumberComplement {
	
	/*
	 * input: 5, output: 2
	 * 5 is 101, to get the mask, use highestOneBit to get 100, left shift, 1000, 
	 * minus 1, get 111, & with the negative number to get the flip result
	 */
	public static int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

	public static void main(String[] args) {
		System.out.println(findComplement(5));
		System.out.println(findComplement(1));
		System.out.println(findComplement(100));
	}

}
