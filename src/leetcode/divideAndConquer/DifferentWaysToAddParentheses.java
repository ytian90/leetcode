package leetcode.divideAndConquer;

import java.util.LinkedList;
import java.util.List;

/**
 * 286. Different Ways to Add Parentheses
 * @author yutian
 * @since Aug 13, 2015
 */
public class DifferentWaysToAddParentheses {
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '+') {
				String aStr = input.substring(0, i);
				String bStr = input.substring(i + 1);
				List<Integer> aRes = diffWaysToCompute(aStr);
				List<Integer> bRes = diffWaysToCompute(bStr);
				for (Integer a: aRes) {
					for (Integer b: bRes) {
						int c = 0;
						switch(input.charAt(i)) {
							case '+':
								c = a + b;
								break;
							case '-':
								c = a - b;
								break;
							case '*':
								c = a * b;
								break;
						}
						res.add(c);
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("100"));
		System.out.println(diffWaysToCompute("2-1-1"));
		System.out.println(diffWaysToCompute("0+1"));
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}
}
