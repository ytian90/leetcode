package array;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums
 */
public class SumOfSubarrayMinimums {

    public static int sumSubarrayMins(int[] A) {
        int res = 0, n = A.length, mod = (int) 1e9 + 7;
        int[] l = new int[n], r = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i]) {
                count += s1.pop()[1];
            }
            s1.push(new int[]{A[i], count});
            l[i] = count;
        }
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i]) {
                count += s2.pop()[1];
            }
            s2.push(new int[]{A[i], count});
            r[i] = count;
        }
        for (int i = 0; i < n; i++) {
            res = (res + A[i] * l[i] * r[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
        System.out.println(sumSubarrayMins(new int[]{2, 1, 3, 1}));
    }
}
