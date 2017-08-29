package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * @author yutian
 * @since Aug 15, 2015
 */
public class LetterCombinationsOfAPhoneNumber {
	
	// backtracking DFS: Time complexity of above code is O(4^n) 
	// where n is number of digits in input number.
	// Space ~ O(N) 
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", 
        		"mno", "pqrs", "tuv", "wxyz"};
        addUp(digits, 0, new StringBuilder(), map, res);
        return res;
    }
    
    private void addUp(String digits, int start, StringBuilder sb, String[] map, 
    		List<String> res) {
    	if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            for (char c: map[x].toCharArray()) {
                sb.append(c);
                addUp(digits, i + 1, sb, map, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
	
	// iterative Time complexity of above code is O(4^n) 
	public List<String> letterCombinations2(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if (digits == null || digits.length() == 0) return res;
		String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", 
									"mno", "pqrs", "tuv", "wxyz"};
		res.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (res.peek().length() == i) {
				String t = res.remove();
				for (char s: map[x].toCharArray()) {
					res.add(t + s);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber ins = new LetterCombinationsOfAPhoneNumber();
		System.out.println(ins.letterCombinations2("23"));
	}
	
}
