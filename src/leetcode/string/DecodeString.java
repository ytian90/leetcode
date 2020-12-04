package leetcode.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. Decode String
 * @author yutian
 * @since Sep 5, 2016
 */
public class DecodeString {

    public static String decodeString(String s) {
        Deque<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }
        return helper(q);
    }

    public static String helper(Deque<Character> q) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            } else if (c == '[') {
                String sub = helper(q);
                for (int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));

    }
}
