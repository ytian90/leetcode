package util;

import java.util.*;

public class test {
    public static boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }

    public static String getString(String S) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '#') {
                count++;
                continue;
            }
            if (count > 0) {
                count--;
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ab#c"));
    }

}