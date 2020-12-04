package leetcode.math;

/**
 * 829. Consecutive Numbers Sum
 */
public class ConsecutiveNumbersSum {

    public static int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1, n = N - 1; n >= 0; n -= ++i) {
            if ((n % i) == 0) res++;
        }
        return res;
    }

    public static int consecutiveNumbersSum2(int N) {
        int res = 1, count;
        while (N % 2 == 0) N /= 2;
        for (int i = 3; i * i <= N; res *= count + 1, i += 2)
            for (count = 0; N % i == 0; N /= i, count++);
        return N == 1 ? res : res * 2;
    }

    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(14));
    }
}
