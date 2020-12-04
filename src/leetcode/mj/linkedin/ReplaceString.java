package leetcode.mj.linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Replace String
 */
public class ReplaceString {

    /*
    Time: Suppose len(orig) = m, len(find) = n, then we need O(mn) time to leetcode.sort
    and O(m + leetcode.sort*n) time to replace.
    Space: O(m), we need extra space to store the start index of a found pattern in the original leetcode.string.
     */
    public static String replace(String origin, String find, String replace) {
        List<Integer> index = findPattern(origin, find);
        int count = index.size();
        // compute length after replacement
        int newLen = origin.length() + count * (replace.length() - find.length());
        char[] res = new char[newLen];
        // replace
        int i = 0, k = 0;
        int resIndex = 0;
        while (i < origin.length()) {
            if (k < count && i == index.get(k)) {
                for (int j = 0; j < replace.length(); j++) {
                    res[resIndex++] = replace.charAt(j);
                }
                k++;
                i += find.length();
            } else {
                res[resIndex++] = origin.charAt(i++);
            }
        }
        return new String(res);
    }

    private static List<Integer> findPattern(String orig, String find) {
        List<Integer> index = new ArrayList<>();
        int i = 0, j = 0;
        while (i + find.length() <= orig.length()) {
            int k = i;
            j = 0;
            while (j < find.length()) {
                if (orig.charAt(k) != find.charAt(j)) {
                    break;
                }
                k++;
                j++;
            }
            if (j == find.length()) {
                index.add(i);
                i += find.length();
            } else {
                i++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(replace("babcc", "abc", "cab"));
    }

    public String replace2(String origin, String from, String to) {
        if (origin.length() < from.length() || from.equals(to))
            return origin;
        int len = from.length();
        int[] count = new int[26];
        for (char letter : from.toCharArray()) {
            count[letter - 'a']++;
        }
        int[] currCount = new int[26];
        int slow = 0;
        int fast = 0;
        while (fast < origin.length()) {
            if (fast - slow + 1 <= len) {
                currCount[origin.charAt(fast) - 'a']++;
            } else {
                boolean isSame = true;
                for (int i = 0; i < currCount.length; i++) {
                    if (currCount[i] == count[i]) {
                        isSame = isSame && true;
                    } else {
                        isSame = false;
                    }
                }
                if (isSame && origin.substring(slow, fast).equals(from)) {
                    origin = origin.substring(0, slow) + to + origin.substring(fast);
                    Arrays.fill(currCount, 0);
                    fast = slow;
                    continue;
                }
                currCount[origin.charAt(slow) - 'a']--;
                slow++;
                currCount[origin.charAt(fast) - 'a']++;
            }
            fast++;
        }
        return origin;
    }
}
