package mj.houzz;

import java.math.BigInteger;

/**
 * Given 20, 11
 * output:
 * 20 = 2 * 2 * 5
 * 11 = 11
 * followup:
 * 20 = 2 ^ 2 * 5
 * followup2:
 * 20 = 5 * 2 ^ 2
 *
 */
public class ResolvePrime {

    // ???
    public static void main (String[] args) {
        ResolvePrime test = new ResolvePrime();
        int[] nums = {1, 2, 3, 4, 17, 20, 90}; // 3, 17, 20, 90
        for (int i = 0; i < nums.length; i++) {
            System.out.println(test.resolvePrime3(nums[i]));
        }

        String s = "rft567.908kih000000hh890jug678gtff567";
        String[] list = s.split("[^0-9]+");
        for (String a: list) {
            System.out.println(a);
        }

    }
    public String resolvePrime(int num) {
        BigInteger prime = new BigInteger(String.valueOf(2));
        int total = num;
        StringBuilder sb = new StringBuilder("");
        if (num < prime.intValue()) {
            return String.valueOf(num);
        }
        while (prime.intValue() <= total) {
            while (total % prime.intValue() == 0) {
                sb.append(prime);
                sb.append("*");
                total /= prime.intValue();
            }
            prime = prime.nextProbablePrime();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // follow up: 20 = 2^2 * 5
    public String resolvePrime2(int num) {
        BigInteger prime = new BigInteger(String.valueOf(2));
        int total = num;
        StringBuilder sb = new StringBuilder("");
        if (num < prime.intValue()) {
            return String.valueOf(num);
        }
        while (prime.intValue() <= total) {
            int count = 0;
            while (total % prime.intValue() == 0) {
                count++;
                total /= prime.intValue();
            }
            if (count > 1) {
                sb.append(prime);
                sb.append("^");
                sb.append(count);
                sb.append("*");
            } else if (count == 1) {
                sb.append(prime);
                sb.append("*");
            }
            prime = prime.nextProbablePrime();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // follow up: 20 = 5 * 2 ^ 2
    public String resolvePrime3(int num) {
        BigInteger prime = new BigInteger(String.valueOf(2));
        int total = num;
        StringBuilder sb = new StringBuilder("");
        if (num < prime.intValue()) {
            return String.valueOf(num);
        }
        while (prime.intValue() <= total) {
            int count = 0;
            while (total % prime.intValue() == 0) {
                count++;
                total /= prime.intValue();
            }
            StringBuilder t = new StringBuilder();
            if (count > 1) {
                t.append(prime);
                t.append("^");
                t.append(count);
                t.append("*");
            } else if (count == 1) {
                t.append(prime);
                t.append("*");
            }
            t.append(sb.toString());
            sb = t;
            prime = prime.nextProbablePrime();
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
