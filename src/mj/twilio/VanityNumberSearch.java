package mj.twilio;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-560264-1-1.html
 *
 */
public class VanityNumberSearch {
    private static final List<Character> map = Arrays.asList
            ('2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9');

    public static List<String> vanity(List<String> codes, List<String> phones) {
        if (codes == null || codes.size() == 0 || phones == null || phones.size() == 0) {
            return null;
        }
        List<String> res = new ArrayList<>();
        Set<String> codeNum = new HashSet<>();
        for (String s : codes) {
            codeNum.add(mapToInt(s));
        }
        int n = codes.get(0).length();
        for (String phone : phones) {
            for (int i = 1; i <= phone.length() - n; i++) {
                if (codeNum.contains(phone.substring(i, i + n))) {
                    res.add(phone);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    private static String mapToInt(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(map.get(c - 'A'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(vanity(Arrays.asList("TWLO", "CODE", "HTCH"), Arrays.asList("+17474824380", "+14157088956", "+919810155555", "+15109926333", "+1415123456")));
    }
}
