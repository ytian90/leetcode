package leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 * @author ytian
 *
 */
public class ExclusiveTimeOfFunctions {
	
	public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log : logs) {
        	String[] parts = log.split(":");
        	if (!stack.isEmpty()) {
        		res[stack.peek()] += Integer.parseInt(parts[2]) - prev;
        	}
        	prev = Integer.parseInt(parts[2]);
        	if (parts[1].equals("start")) {
        		stack.push(Integer.parseInt(parts[0]));
        	} else {
        		res[stack.pop()]++;
        		prev++;
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		List<String> log1 = Arrays.asList(
				 "0:start:0",
				 "1:start:2",
				 "1:end:5",
				 "0:end:6");
		
		System.out.println(Arrays.toString(exclusiveTime(2, log1)));
	}

}
