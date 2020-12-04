package leetcode.math;

import java.util.Arrays;

/**
 * 942. DI String Match
 */
public class DIStringMatch {

    public static int[] diStringMatch(String S) {
        if (S == null || S.length() == 0)
            return new int[]{};
        int n = S.length(), left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }
        }
        res[n] = left;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        System.out.println(Arrays.toString(diStringMatch("III")));
        System.out.println(Arrays.toString(diStringMatch("DDI")));

    }
}
