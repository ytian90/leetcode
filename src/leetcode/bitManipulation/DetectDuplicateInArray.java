package leetcode.bitManipulation;

public class DetectDuplicateInArray {
	
	//0 < arr[i] <= length for all and 0 <= i < length

	//brute-force
	//leetcode.sort and check
	//leetcode.hashtable
	//bit manipulation

	public static void main(String[] args) {
		int[] test = new int[]{0,3,2};
		System.out.println(hasDuplicate(test));
	}
	
	public static boolean hasDuplicate(int[] arr) {
		int check = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			check ^= arr[i] ^ i;
		}
		return check != 0;
	}

}
