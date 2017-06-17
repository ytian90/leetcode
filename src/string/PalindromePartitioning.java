package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 * @author yutian
 * @since Aug 23, 2015
 */
public class PalindromePartitioning {
	
	// Solution 1
	public static List<List<String>> partition(String s) {
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
    
    public static void main(String[] args) {
    	List<List<String>> t = partition2("aabcb");
    	for (List<String> i: t) {
    		System.out.println(i);
    	}
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
