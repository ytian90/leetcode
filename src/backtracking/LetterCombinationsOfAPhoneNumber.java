package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * @author yutian
 * @since Aug 15, 2015
 */
public class LetterCombinationsOfAPhoneNumber {
	
	// backtracking DFS: Time complexity of above code is O(4^n) 
	// where n is number of digits in input number.
	// Space ~ O(N) 
	public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", 
        		"mno", "pqrs", "tuv", "wxyz"};
        addUp(digits, 0, new StringBuilder(), map, result);
        return result;
    }
    
    private void addUp(String digits, int start, StringBuilder sb, String[] map, 
    		List<String> result) {
    	if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            for (char c: map[x].toCharArray()) {
                sb.append(c);
                addUp(digits, i + 1, sb, map, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
	
	// iterative Time complexity of above code is O(4^n) 
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if (digits == null || digits.length() == 0) return result;
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", 
									"mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String t = result.remove();
				for (char s: map[x].toCharArray()) {
					result.add(t + s);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber ins = new LetterCombinationsOfAPhoneNumber();
		System.out.println(ins.letterCombinations2("23"));
	}
	
}
