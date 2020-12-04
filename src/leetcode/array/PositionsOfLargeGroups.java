package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 830. Positions of Large Groups
 */
public class PositionsOfLargeGroups {

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() == 0)
            return res;
        int start = 0, count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    res.add(new ArrayList<>(Arrays.asList(start, i - 1)));
                }
                count = 1;
                start = i;
            }
        }
        if (count >= 3) {
            res.add(new ArrayList<>(Arrays.asList(start, S.length() - 1)));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largeGroupPositions("abbxxxxzzy"));
        System.out.println(largeGroupPositions("abc"));
        System.out.println(largeGroupPositions("abcdddeeeeaabbbcd"));
        System.out.println(largeGroupPositions("aaa"));
    }
}
