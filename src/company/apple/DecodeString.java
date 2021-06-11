package company.apple;

import java.util.Stack;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=755331&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class DecodeString {
    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> freq = new Stack<>();
        Stack<String> strs = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length();) { // no i++ here
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                freq.push(Integer.valueOf(s.substring(start, i)));
            } else if (c == '[') {
                strs.push(res);
                res = "";
                i++;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(strs.pop());
                int size = freq.pop();
                for (int j = 0; j < size; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += c;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("2[ab3[cd]]"));
    }
}
