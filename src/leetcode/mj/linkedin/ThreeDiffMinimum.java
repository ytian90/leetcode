package leetcode.mj.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Questiion:
Given three sorted arrays A[], B[] and C[], find 3 elements i, j and k from A, B and C respectively such that
max(abs(A – B[j]), abs(B[j] – C[k]), abs(C[k] – A)) is minimized. Here abs() indicates absolute value.
Example :
Input: A[] = {1, 4, 10}  B[] = {2, 15, 20} C[] = {10, 12} Output: 10 15 10。 10 from A, 15 from B and 10 from C
Input: A[] = {20, 24, 100} B[] = {2, 19, 22, 79, 800} C[] = {10, 12, 23, 24, 119}
Output: 24 22 23。24 from A, 22 from B and 23 from C

Solution;
use three pointers
O(n);
 */
public class ThreeDiffMinimum {
    public static List<Integer> getMin(int[] A, int[] B, int[] C) {
        List<Integer> res = new ArrayList<>();
        if (A == null || B == null || C == null)
            return res;
        int min = Integer.MAX_VALUE;
        int pa = 0, pb = 0, pc = 0;
        while (pa < A.length && pb < B.length && pc < C.length) {
            int a = A[pa], b = B[pb], c = C[pc];
            int curr = Math.abs(a - b) + Math.abs(b - c) + Math.abs(a - c);
            if (curr < min) {
                min = curr;
                res.clear();
                res.addAll(Arrays.asList(a, b, c));
            }
            if (a <= b && a <= c) {
                pa++;
            } else if (c <= b && c <= a) {
                pc++;
            } else {
                pb++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMin(new int[]{1, 4, 10}, new int[]{2, 15, 20}, new int[]{10, 12}));
        System.out.println(getMin(new int[]{20, 24, 100}, new int[]{2, 19, 22, 79, 800}, new int[]{10, 12, 23, 24, 119}));
    }
}
