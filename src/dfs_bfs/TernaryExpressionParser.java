package dfs_bfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 439. Ternary Expression Parser
 * @author ytian
 *
 */
public class TernaryExpressionParser {
	
	public static String parseTernary(String expression) {
        if (expression == null || expression.length() == 0)
        	return "";
        Deque<Character> stack = new LinkedList<>();
        int len = expression.length();
        
        for (int i = len - 1; i >= 0; i--) {
        	char c = expression.charAt(i);
        	if (!stack.isEmpty() && stack.peek() == '?') {
        		stack.pop(); // pop '?'
        		char first = stack.pop();
        		stack.pop(); // pop ':'
        		char second = stack.pop();
        		if (c == 'T') stack.push(first);
        		else stack.push(second);
        	} else {
        		stack.push(c);
        	}
        }
        return String.valueOf(stack.peek());
    }

	public static void main(String[] args) {
		System.out.println(parseTernary("T?2:3"));
		System.out.println(parseTernary("F?1:T?4:5"));
		System.out.println(parseTernary("T?T?F:5:3"));
	}

}
