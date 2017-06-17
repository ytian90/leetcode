package array;

import java.util.ArrayList;

/**
 * Array Length Encoding
 * @author yutian
 * @since Dec 13, 2015
 */
public class ArrayLengthEncoding {
	
	// Time ~O(N) Space ~O(N)
	public static ArrayList<Integer> encodeLength(int[] arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (arr == null || arr.length == 0) {
			result.add(0);
			result.add(0);
			result.add(1);
			result.add(0);
			return result;
		}
		
		int len = arr.length;
		int curr = arr[0];
		result.add(curr);
		int freq = 1;
		for (int i = 1; i < len; i++) {
			if (curr == arr[i]) {
				freq++;
			} else {
				curr = arr[i];
				result.add(freq);
				result.add(curr);
				freq = 1;
			}
		}
		result.add(freq);
		return result;
	}

	public static void main(String[] args) {
		int[] test = new int[]{1,1,1,0,0,1,1,0,1};
		for(int n: encodeLength(test)){
			System.out.print(n);
		}
	}

}
