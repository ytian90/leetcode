package mj.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给一个长度n，代表着长度为n的二进制串（只有0和1），然后给一个起始串，一个结束串，和一个合法路径串的集合，每次允许翻转二进制串的一位，问从起始到结束的最短步数。
 * follow-up1: 不用字符串，用整数怎么表示
 * follow-up2: 这个api可能会调用多次，怎么高效
 */
public class NumLadder {
    public static int numLadder(int n, String begin, String end, Set<String> dict) {
        Set<String> reached = new HashSet<>();
        if (!dict.contains(end)) {
            return 0;
        }
        reached.add(begin);
        int res = 1;
        while (!reached.contains(end)) {
            Set<String> next = new HashSet<>();
            for (String s : reached) {
                for (int i = 0; i < n; i++) {
                    char[] chars = s.toCharArray();
                    for (char c = '0'; c <= '1'; c++) {
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (dict.contains(newStr)) {
                            next.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
            res++;
            if (next.size() == 0) {
                return 0;
            }
            reached = next;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numLadder(4, "0010", "1100", new HashSet<>(Arrays.asList("0110", "0000", "0100", "1100"))));
    }
}
