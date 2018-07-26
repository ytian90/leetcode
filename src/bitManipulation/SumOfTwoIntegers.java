package bitManipulation;
/**
 * 371. Sum of Two Integers
 * Explain: 
 * http://stackoverflow.com/questions/9070937/adding-two-numbers-without-operator-clarification
 * @author yutian
 * @since Jul 2, 2016
 */
public class SumOfTwoIntegers {
	
	public static int getSum(int a, int b) {
        if (b == 0) return a;
        int carry = (a & b) << 1;
        int sum = a ^ b;
        return getSum(sum, carry);
    }

	public static void main(String[] args) {
		System.out.println(getSum(3, 5));
		System.out.println(getSum(2, 5));
		System.out.println(getSum(-2, 3));
		System.out.println(getSum(3, -5));
		System.out.println(getSum(0, 3));
	}

}
