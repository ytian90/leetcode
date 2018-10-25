package mj.linkedin;

/**
 Question:
 切圆n刀，最多切成多少块

 Solution:
 // cut cirlcle
 f(1) = 2
 f(2) = 2 + f(1) = 4
 f(3) = 3 + f(2) = 7
 f(n) = n + f(n - 1)
 = n + n - 1 + n - 2 + .. + 2 + f(1)
 = (n + 2) * (n - 1) / 2 + f(1) = (n ^ 2 - 2n - 2) / 2 + 2
 */
public class CutCircle {

    public static int cutCircle(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2 ; i <= n; i++) {
            dp[i] = i + dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutCircle(3));
        System.out.println(cutCircle(4));
    }
}
