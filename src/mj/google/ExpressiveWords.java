package mj.google;

/**
 * lc809
 */
public class ExpressiveWords {
    public static int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word : words) {
            if (match(S, word)) {
                res++;
            }
        }
        return res;
    }

    private static boolean match(String S, String W) {
        int n = S.length(), m = W.length(), j = 0;
        for (int i = 0; i < n; i++) {
            if (j < m && S.charAt(i) == W.charAt(j)) {
                j++;
            } else if (i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i - 2));
            else if (i > 0 && i < n - 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i + 1));
            else return false;
        }
        return j == m;
    }

    public static void main(String[] args) {
        System.out.println(expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(expressiveWords("lee", new String[]{"le"}));
    }
}
