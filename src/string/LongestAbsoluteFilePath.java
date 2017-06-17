package string;

import java.util.Stack;

/**
 * 388. Longest Absolute File Pathß
 * @author yutian
 * @since Aug 29, 2016
 */
public class LongestAbsoluteFilePath {
	
	public int lengthLongestPath(String input) {
        int max = 0, len = input.length(), i = 0, pathLen = 0, curDepth = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < len) {
        	while (stack.size() > curDepth) pathLen -= stack.pop();
        	int curLen = 0; curDepth = 0;
        	boolean isFile = false;
        	while (i < len && input.charAt(i) != '\n') {
        		if (input.charAt(i) == '.') isFile = true;
        		i++; curLen++;
        	}
        		
        	if (isFile) max = Math.max(max, curLen + pathLen);
        	else pathLen += stack.push(curLen + 1);
        	i++;
        	while (i < len && input.charAt(i) == '\t') {
        		curDepth++;
        		i++;
        	}
        }
        return max;
    }
	
	public int lengthLongestPath2(String input) {
		int max = 0, len = input.length(), i = 0, curDepth = 0;
		int[] table = new int[len / 2 + 1];
		while (i < len) {
			int curLen = 0;
			boolean isFile = false;
			while (i < len && input.charAt(i) != '\n') {
				if (input.charAt(i) == '.') isFile = true;
				i++; curLen++;
			}
			table[curDepth] = (curDepth == 0 ? 0 : table[curDepth - 1]) + curLen + 1;
			if (isFile) max = Math.max(max, table[curDepth] - 1);
			i++;
			curDepth++;
			while (i < len && input.charAt(i) == '\t') {
				curLen++;
			}
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
