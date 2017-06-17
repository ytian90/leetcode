package string;

import java.util.Arrays;

/**
 * 556. Next Greater Element 3
 * @author ytian
 *
 */
public class NextGreaterElement3 {
	
	/*
	 * 1. If all digits sorted in descending order, then output is always “Not Possible”. For example, 4321.
	 * 2. If all digits are sorted in ascending order, then we need to swap last two digits. For example, 1234.
	 * 3. For other cases, we need to process the number from rightmost side 
	 * (why? because we need to find the smallest of all greater numbers)
	 */
	
	public static int nextGreaterElement(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int i = num.length - 1, j;
        // Start from the right most digit and find the first digit that is smaller than the digit next to it.
        while (i > 0 && num[i - 1] >= num[i]) i--;
        
        // If no such digit is found, its the edge case 1
        if (i == 0) return -1;
        // Find the smallest digit on right side of (i-1)'th 
        // digit that is greater than number[i-1]
        int x = num[i - 1], smallest = i;
        for (j = i + 1; j < num.length; j++) {
        	if (num[j] > x && num[j] <= num[smallest]) {
        		smallest = j;
        	}
        }
        // Swap the above found smallest digit with num[i - 1]
        char temp = num[i - 1];
        num[i - 1] = num[smallest];
        num[smallest] = temp;
        
        // Sort the digits after (i - 1) in ascending order
        Arrays.sort(num, i, num.length);
        
        long val = Long.parseLong(new String(num));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }

	public static void main(String[] args) {
//		System.out.println(nextGreaterElement(12));
//		System.out.println(nextGreaterElement(21));
		System.out.println(nextGreaterElement(11));
	}

}
