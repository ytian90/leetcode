package greedy;

/**
 * 402. Remove K Digits
 * @author yutian
 *
 */
public class RemoveKDigits {
	
	public static String removeKdigits(String num, int k) {
		if (num == null || num.length() == 0 || k > num.length()) {
			return "0";
		}
        int digits = num.length() - k;
        char[] stack = new char[num.length()];
        int top = 0;
        for (Character c : num.toCharArray()) {
        	while (top > 0 && stack[top - 1] > c && k > 0) {
        		top--; k--;
        	}
        	stack[top++] = c;
        }
        int index = 0;
        while (index < digits && stack[index] == '0') index++;
        return index == digits ? "0" : new String(stack, index, digits - index);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeKdigits("1432219", 3));
		System.out.println(removeKdigits("10200", 1));
		System.out.println(removeKdigits("10", 2));
		System.out.println(removeKdigits("10", 3));
	}

}
