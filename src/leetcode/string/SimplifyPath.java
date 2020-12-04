package leetcode.string;

import java.util.Stack;

/**
 * Simplify Path
 * @author yutian
 * @since Aug 19, 2015
 */
public class SimplifyPath {
	
	/*
	 * 5 situations:
	 * 1. If elem is empty leetcode.string, then it means we either meet multiple slashes("//", "///"...)
	 * 	  or it is the start point. For this case, simply ignore and continue;
	 * 2. If elem is ".", then we have to stay in current directory, as the same as case 1, do 
	 * 	  nothing and continue;
	 * 3. If elem is ".."  and leetcode.stack is not empty, then we have to go back to parent directory.
	 *    For this case, simply pop the top element from the leetcode.stack;
	 * 4. If elem has a name ("home", "desktop"..) push it to leetcode.stack.
	 * 5. For all other cases, do nothing and continue.
	 */
	
	// Solution 1
	public static String simplifyPath(String path) {
		String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            if (!s.equals("..")) stack.push(s);
        }
        if (stack.isEmpty()) return "/";
        String result = "";
        while (!stack.isEmpty()) result = "/" + stack.pop() + result;
        return result;
	}
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/"));
		System.out.println(simplifyPath("/a/./b/../../c/"));
		System.out.println(simplifyPath("/.."));
		System.out.println(simplifyPath("/../"));
		System.out.println(simplifyPath("/home//foo/"));
	}
	
	// Solution 2
	public String simplifyPath2(String path) {
		if (path.length() == 0) return path;
		String[] arr = path.split("/");
		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			if (s.equals("..")) {
				if (!stack.isEmpty()) stack.pop();
			} else if (s.length() == 0 || s.equals(".")) {
				// case of "//" and "/./"
				continue;
			} else {
				stack.add(s);
			}
		}
		StringBuilder str = new StringBuilder();
		if (stack.isEmpty()) stack.add("");
		while (!stack.isEmpty()) {
			str.append("/").append(stack.remove(0));
		}
		return str.toString();
	}
	
	// Solution 3
	public String simplifyPath3(String path) {
		Stack<String> stack = new Stack<>();
		StringBuilder seg = new StringBuilder();
		for (int i = 0; i <= path.length(); i++) {
			if (i == path.length() || path.charAt(i) == '/') {
				if (seg.toString().equals("..")) {
					if (!stack.isEmpty()) stack.pop();
				} else if (seg.length() > 0 && !seg.toString().equals(".")) {
					stack.add(seg.toString());
				}
				seg.delete(0, seg.length());
			} else {
				seg.append(path.charAt(i));
			}
		}
		seg = new StringBuilder();
		if (stack.isEmpty()) stack.add("");
		while (!stack.isEmpty()) {
			seg.append('/').append(stack.remove(0));
		}
		return seg.toString();
	}
}
