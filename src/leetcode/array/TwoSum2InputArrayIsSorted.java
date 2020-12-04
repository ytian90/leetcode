package leetcode.array;
/**
 * 167. Two Sum 2 - Input leetcode.array is sorted
 * @author yutian
 * @since Dec 27, 2015
 */
public class TwoSum2InputArrayIsSorted {
	
	// Solution 1: Two Pointers Time ~ O(n)
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
        	int v = numbers[i] + numbers[j];
        	if (v == target) {
        		return new int[]{i + 1, j + 1};
        	} else if (v < target) {
        		i++;
        	} else {
        		j--;
        	}
        }
        return null;
    }
    
    // Solution 2: Binary Search
    public static int[] twoSum2(int[] numbers, int target) {
    	if (numbers == null) return null;
    	for (int i = 0; i < numbers.length - 1; i++) {
    		int start = i + 1, end = numbers.length - 1, gap = target - numbers[i];
    		while (start <= end) {
    			int m = start + (end - start) / 2;
    			if (numbers[m] == gap) { return new int[]{i + 1, m + 1}; }
    			else if (numbers[m] > gap) end = m - 1;
    			else start = m + 1;
    		}
    	}
    	return null;
    }

	public static void main(String[] args) {
		int[] t = new int[]{2, 3, 4};
		int[] r = twoSum2(t, 6);
		for (int i : r) {
			System.out.print(i + " ");
		}
	}

}
