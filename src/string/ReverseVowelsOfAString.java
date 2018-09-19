package string;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 345. Reverse Vowels of a String
 * @author yutian
 * @since May 7, 2016
 */
public class ReverseVowelsOfAString {
	
	/* Two Pointers time O(N) */
	public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vow = "aeiouAEIOU";
        // way 1 too slow.. 117ms
//        Set<Character> set = vow.chars().mapToObj(e->(char)e).collect(Collectors.toSet());
        // way 2 11ms
        Set<Character> set = new HashSet<>();
        for (Character c : vow.toCharArray()) {
        		set.add(c);
        }
        char[] chars = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
	        	while (start < end && !set.contains(chars[start])) {
	        		start++;
	        	}
	        	while (start < end && !set.contains(chars[end])) {
	        		end--;
	        	}
	        	swap(chars, start, end);
	        	start++; end--;
        }
        return new String(chars);
    }
	
	private void swap(char[] c, int i, int j) {
		char tmp = c[i];
		c[i] = c[j];
		c[j] = tmp;
	}
	
	/* Stack to reverse vowels time O(2N) */
	public String reverseVowels2(String s) {
		if (s == null || s.length() == 0) return s;
        String vow = "aeiouAEIOU";
        Set<Character> set = vow.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        // reverse the vowels while popping up
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
	        	if (set.contains(c)) {
	        		stack.push(c);
	        	}
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
	        	if (set.contains(c)) {
	        		sb.append(stack.pop());
	        	} else {
	        		sb.append(c);
	        	}
        }
        return sb.toString();
        
	}
	

	public static void main(String[] args) {
		ReverseVowelsOfAString t = new ReverseVowelsOfAString();
		System.out.println(t.reverseVowels("hello"));
		System.out.println(t.reverseVowels("leetcode"));
	}

}
