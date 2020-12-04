package leetcode.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * 873. Length of Longest Fibonacci Subsequence
 */
public class LengthOfLongestFibonacciSubsequence {

    public static int lenLongestFibSubseq(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int a : A) set.add(a);
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i], b = A[j], l = 2;
                while (set.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res > 2 ? res : 0;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
