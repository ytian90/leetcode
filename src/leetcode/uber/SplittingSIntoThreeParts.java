package leetcode.uber;

/**
 * https://leetcode.com/discuss/interview-question/949185/uber-sde-1-us-codesignal-oa
 *
 * Given a string S, Count number of ways of splitting S into 3 non-empty a,b,c such that a+b, b+c, c+a are all different.
 *
 * ex. xzxzx OP: 5
 *  x, z, xzx
 * 	x, zx, zx
 * 	xz, x, zx
 * 	xz, xz, x
 * 	xzx, z, x
 * ex. xxx OP : 0
 *
 */
public class SplittingSIntoThreeParts {

    public static int count(String s) {
        if (s.length() < 3) return 0;
        int n = s.length(), res = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < i; j++) {
                String a = s.substring(0, j + 1);
                String b = s.substring(j + 1, i + 1);
                String c = s.substring(i + 1);
                if (a.equals(b) || b.equals(c) || a.equals(c)) {
                    continue;
                }
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count("12312"));
    }
}
