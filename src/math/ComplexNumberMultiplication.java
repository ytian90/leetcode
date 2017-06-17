package math;

import java.util.stream.Stream;

/**
 * 537. Complex Number Multiplication
 * @author ytian
 *
 */
public class ComplexNumberMultiplication {
	
	public static String complexNumberMultiply(String a, String b) {
        String[] A = a.split("\\+");
        String[] B = b.split("\\+");
        int a1 = Integer.parseInt(A[0]);
        int b1 = Integer.parseInt(A[1].replace("i", ""));
        int a2 = Integer.parseInt(B[0]);
        int b2 = Integer.parseInt(B[1].replace("i", ""));
        int a12 = a1 * a2;
        int b12 = b1 * b2;
        int ab12 = (a1 * b2) + (b1 * a2);
        String aa = (a12 + (-1) * b12) + "";
        String bb = ab12 + "i";
        return aa + "+" + bb;
    }
	
	public static String complexNumberMultiply1(String a, String b) {
		int[] c1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
		int[] c2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
		return (c1[0] * c2[0] - c1[1] * c2[1]) + "+" + (c1[0] * c2[1] + c1[1] * c2[0]) + "i";
	}

	public static void main(String[] args) {
		String test1_a = "1+1i", test1_b = "1+1i";
		System.out.println(complexNumberMultiply(test1_a, test1_b));
		String test2_a = "1+-1i", test2_b = "1+-1i";
		System.out.println(complexNumberMultiply1(test2_a, test2_b));
	}

}
