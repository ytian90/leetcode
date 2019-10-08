package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. Remove Comments
 */
public class RemoveComments {

    public static List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (mode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        mode = true;
                        i++;
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!mode && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeComments(new String[]{
                "/*Test program */",
                "int main()",
                "{",
                "// variable declaration",
                "int a, b, c;",
                "/* This is a test",
                "multiline  ",
                "   comment for ",
                "testing */",
                "a = b + c;",
                "}"
        }));
    }
}
