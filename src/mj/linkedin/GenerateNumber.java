package mj.linkedin;

import java.math.BigInteger;
import java.util.List;

/**
 * http://wxx5433.github.io/generate-number.html
 *
 * Generate number:
 * There is a particular sequence that only uses numbers 1, 2, 3, 4 and no two adjacent numbers are the same.
 * Write a program that given n1 1s, n2 2s, n3 3s, n4 4s will output the number of such sequences using all these numbers.
 * Output your answer modulo 1000000007 (10^9 + 7).
 */
public class GenerateNumber {
    public static void generateNumber(List<Integer> result, String number, int[] count, int len) {
        if (number.length() == len) {
            BigInteger num = new BigInteger(number).mod(new BigInteger("1000000007"));
            result.add(new Integer(num.toString()));
            return ;
        }

        for (int i = 0; i < 4; ++i) {
            int num = i + 1;
            if (count[i] > 0 && (number.length() == 0
                    || number.charAt(number.length() - 1) - '0' != num)) {
                --count[i];
                generateNumber(result, number + num, count, len);
                ++count[i];
            }
        }
    }
}
