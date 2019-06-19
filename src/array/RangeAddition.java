package array;
/**
 * 370. Range Addition
 * @author yutian
 * @since Jul 2, 2016
 */
public class RangeAddition {
	
	public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update: updates) {
        	int value = update[2];
        	int start = update[0];
        	int end = update[1];
        	res[start] += value;
        	if (end < length - 1) {
        		res[end + 1] -= value;
        	}
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
        	sum += res[i];
        	res[i] = sum;
        }
        return res;
    }

	public static void main(String[] args) {
		int[][] updates = {{1, 3, 2}, {2, 3, 3}};
		for (int i: getModifiedArray(5, updates)) {
			System.out.println(i);			
		}
	}
	
	/*
	 * Store every start index for each value and at end index plus one minus it
	 * 
	 * We update the value at start index, because it will be used in the future 
	 * when we are adding incr the values for the sum at each index between start
	 * index and end index (both inclusive). We update the negative value at the 
	 * end index + 1, because the positive value of it should be only added at 
	 * its previous indices (from start index to end index). Thus, when we 
	 * accumulate the sum at the end for each index, we will maxPerformance the correct
	 * values for each index. If the end index is the last index in the resulting 
	 * array, we don't have to do the end index + 1 part, because there is no more 
	 * index after the last index and there will be no error when we accumulate 
	 * the sum.
	 */

}
