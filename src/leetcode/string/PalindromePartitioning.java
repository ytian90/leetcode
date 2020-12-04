package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * @author yutian
 * @since Aug 23, 2015
 */
public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s, list, res);
        return res;
    }

    public static void helper(String s, List<String> list, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(s.substring(i), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("cdd"));
        System.out.println(partition("aabcb"));
    }

    public static List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), res);
        return res;
    }

    public static void helper(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (isPalindrome(sub)) {
                list.add(sub);
                helper(s, i, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0)
            return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
	
	// Solution 1
	public static List<List<String>> partition3(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<>();
        dfs(s, 0, list, result);
        return result;
    }
    private static void dfs(String s, int start, List<String> list, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(list));
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                dfs(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
	
	// Solution 2: DFS + DP faster
    public static List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<>();
        int n = s.length();
        if (n == 0 || s == null) return result;
        
        boolean[][] d = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                d[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || d[i + 1][j - 1]);
            }
        }
        dfs(s, d, 0, list, result);
        return result;
    }
    private static void dfs(String s, boolean[][] d, int start, List<String> list, 
    		List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (d[start][i]) {
                list.add(s.substring(start, i + 1));
                dfs(s, d, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
    
    
	
}
