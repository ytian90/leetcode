package math;

import java.util.Scanner;

/**
 * 592. Fraction Addition and Subtraction
 * @author ytian
 *
 */
public class FractionAdditionAndSubtraction {
	
	public static String fractionAddition(String expression) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(expression).useDelimiter("/|(?=[-+])");
        int A = 0, B = 1;
        while (sc.hasNext()) {
        	int a = sc.nextInt(), b = sc.nextInt();
        	A = A * b + a * B;
        	B *= b;
        	int g = gcd(A, B);
        	A /= g;
        	B /= g;
        }
        return A + "/" + B;
    }
	
	private static int gcd(int a, int b) {
		return a != 0 ? gcd(b % a, a) : Math.abs(b);
	}

	public static void main(String[] args) {
		System.out.println(fractionAddition("-1/2+1/2"));
		System.out.println(fractionAddition("-1/2+1/2+1/3"));
		System.out.println(fractionAddition("1/3-1/2"));
		System.out.println(fractionAddition("5/3+1/3"));
	}

}
