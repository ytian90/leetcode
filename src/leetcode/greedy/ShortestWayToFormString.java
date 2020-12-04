package leetcode.greedy;

/**
 * 1055. Shortest Way to Form String
 */
public class ShortestWayToFormString {
    public static int shortestWay(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return -1;
        }
        int n = source.length(), m = target.length();
        int i = 0, j = 0, res = 0, prevJ = 0;
        while (j < m) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i == n) {
                i = 0;
                // if j didn't move forward, letter is not in source
                if (prevJ == j) {
                    return -1;
                }
                prevJ = j;
                res++;
            }
            // if target is completed, still in middle of source
            if (j == m && i > 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(shortestWay("abc", "abcbc")); // 2
        System.out.println(shortestWay("abc", "acdbc")); // -1
        System.out.println(shortestWay("xyz", "xzyxz"));  // 3
        System.out.println(shortestWay("aaaaa", "aaaaaaaaaaaaa")); // 3
    }
}
