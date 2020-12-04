package leetcode.array;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber {

    public static int fib(int N) {
        if (N == 0 || N == 1) return N;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(fib(3));
    }
}
