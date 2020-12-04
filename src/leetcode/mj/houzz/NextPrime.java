package leetcode.mj.houzz;

import java.math.BigInteger;

/**
 * Find next prime number
 */
public class NextPrime {

    // O(n^(3/2)).
    public static int nextPrime(int input) {
        int count = 0;
        input++;
        while (true) {
            count = 0;
            for (int i = 2; i <= Math.sqrt(input); i++) {
                if (input % i == 0) count++;
            }
            if (count == 0) {
                return input;
            } else {
                input++;
            }
        }
    }

    public static int nextPrime2(int input) {
        BigInteger bi = new BigInteger(String.valueOf(input));
        return Integer.parseInt(bi.nextProbablePrime().toString());
    }

    public static void main(String[] args) {
        System.out.println(nextPrime2(6));
        System.out.println(nextPrime2(7));
    }
}
