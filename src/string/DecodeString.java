package string;

import java.util.Stack;

/**
 * 394. Decode String
 * @author yutian
 * @since Sep 5, 2016
 */
public class DecodeString {

    public static String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";
        int i = 0;
        Stack<String> strs = new Stack<>();
        Stack<Integer> times = new Stack<>();
        String res = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                times.add(count);
            } else if (c == '[') {
                strs.add(res);
                res = "";
                i++;
            } else if (c == ']') {
                int time = times.pop();
                StringBuilder sb = new StringBuilder(strs.pop());
                for (int j = 0; j < time; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));

    }
}
