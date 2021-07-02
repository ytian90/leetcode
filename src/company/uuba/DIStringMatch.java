package company.uuba;

/**
 * LC 942. DI String Match
 *
 * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
 *
 * s[i] == 'I' if perm[i] < perm[i + 1], and
 * s[i] == 'D' if perm[i] > perm[i + 1].
 * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
 *
 * Example 1:
 *
 * Input: s = "IDID"
 * Output: [0,4,1,3,2]
 * Example 2:
 *
 * Input: s = "III"
 * Output: [0,1,2,3]
 * Example 3:
 *
 * Input: s = "DDI"
 * Output: [3,2,0,1]
 */
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        if (s == null || s.length() == 0) {
            return new int[]{};
        }
        int n = s.length();
        int left = 0, right = n;
        int[] res = new int[n + 1];
        for (int i = 0; i < n; i++) {
            res[i] = (s.charAt(i) == 'I') ? left++ : right--;
        }
        res[n] = left;
        return res;
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}
