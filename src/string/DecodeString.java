package string;

import java.util.Stack;

/**
 * 394. Decode String
 * @author yutian
 * @since Sep 5, 2016
 */
public class DecodeString {
	
	public static String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (c == '[') {
                resStack.push(res);
                res = "";
                index++;
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                int times = countStack.pop();
                for (int i = 0; i < times; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else {
                res += s.charAt(index++);
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
