package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. Groups of Special-Equivalent Strings
 */
public class GroupsOfSpecialEquivalentStrings {

    public static int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] map1 = new int[256];
            int[] map2 = new int[256];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    map1[s.charAt(i)]++;
                } else {
                    map2[s.charAt(i)]++;
                }
            }
            set.add(Arrays.toString(map1) + " "  + Arrays.toString(map2));
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numSpecialEquivGroups(new String[]{
                "a","b","c","a","c","c"
        }));
        System.out.println(numSpecialEquivGroups(new String[]{
                "aa","bb","ab","ba"
        }));
        System.out.println(numSpecialEquivGroups(new String[]{
                "abc","acb","bac","bca","cab","cba"
        }));
        System.out.println(numSpecialEquivGroups(new String[]{
                "abcd","cdab","adcb","cbad"
        }));
    }
}
