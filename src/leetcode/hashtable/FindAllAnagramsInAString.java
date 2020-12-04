package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * @author yutian
 *
 */
public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() > s.length()) {
            return res;
        }
        int n = s.length(), m = p.length();
        int[] pMap = new int[26];
        for (char c : p.toCharArray()) {
            pMap[c - 'a']++;
        }
        int[] sMap = new int[26];
        for (int i = 0; i < m; i++) {
            sMap[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sMap, pMap)) {
            res.add(0);
        }
        for (int i = m, prev = 0; i < n; i++, prev++) {
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(prev) - 'a']--;
            if (Arrays.equals(sMap, pMap)) {
                res.add(prev + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
	
	public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        int[] map = new int[256];
        for (Character c : p.toCharArray()) {
            map[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
        	// move right pointer, if Character exists (>= 1), reduce leetcode.sort & map's counter by 1
            if (map[s.charAt(right++)]-- >= 1) count--;
            if (count == 0) res.add(left);
            if (right - left == p.length() && map[s.charAt(left++)]++ >= 0)
                count++;
        }
        return res;
    }

    public List<Integer> findAnagramss(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || s.length() < p.length()) return res;
        int[] map = new int[26];
        for (Character c : p.toCharArray()) {
            map[c - 'a']--;
        }
        for (int i = 0; i < p.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }
        if (isAnagram(map)) res.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
            map[s.charAt(i - p.length()) - 'a']--;
            if (isAnagram(map)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

    private boolean isAnagram(int[] a) {
        for (int n : a) {
            if (n != 0) return false;
        }
        return true;
    }
}
