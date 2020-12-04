package leetcode.array;
/**
 * Tug of War
 * http://www.geeksforgeeks.org/tug-of-war/
 * Given a set of n integers, divide the set in two subsets of n/2 sizes 
 * each such that the difference of the sum of two subsets is as minimum 
 * as possible. If n is even, then sizes of two subsets must be strictly 
 * n/2 and if n is odd, then size of one subset must be (n-1)/2 and size 
 * of other subset must be (n+1)/2.
 * @author yutian
 * @since Dec 28, 2015
 */
public class TugOfWar {
	
	public static int[] min_diff = new int[]{Integer.MAX_VALUE};
	
	public static void tugOfWar (int[] arr, int n) {
		// the boolen leetcode.array that contains the inclusion and exclusion of an element
	    // in current set. The number excluded automatically form the other set
		boolean[] curr_elements = new boolean[n];
		// the inclusion/exclusion leetcode.array for final solution
		boolean[] soln = new boolean[n];
		
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			curr_elements[i] = soln[i] = false;
		}
		// Find the solution using recursive function TOWUtil()
		TOWUtil(arr, n, curr_elements, 0, soln, min_diff, sum, 0, 0);
		
		// Print the solutions
		System.out.println("The first subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == true) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		System.out.println("The second subset is: ");
		for (int i = 0; i < n; i++) {
			if (soln[i] == false) {
				System.out.print(arr[i] + " ");
			}
		}
		
	}

	private static void TOWUtil(int[] arr, int n, boolean[] curr_elements, 
			int no_of_selected, boolean[] soln, int[] min_diff, int sum, 
			int curr_sum, int curr_position) {
		// checks whether it is going out of bound
		if (curr_position == n) return;
		
		// checks that the number of elements left are not less than the 
		// number of elements required to form the solution.
		if ((n / 2 - no_of_selected) > (n - curr_position)) return;
		
		// consider the cases when current element is not included in the solution
		TOWUtil(arr, n, curr_elements, no_of_selected, soln, min_diff, sum, curr_sum, curr_position + 1);
		
		// add the current element to the solution
		no_of_selected++;
		curr_sum += arr[curr_position];
		curr_elements[curr_position] = true;
		
		// checks if a solution is formed
		if (no_of_selected == n / 2) {
			// checks if the solution formed is better than the best solution so far
			if (Math.abs(sum / 2 - curr_sum) < min_diff[0]) {
				min_diff[0] = Math.abs(sum / 2 - curr_sum);
				for (int i = 0; i < n; i++) {
					soln[i] = curr_elements[i];
				}
			}
		} else {
			// consider the cases where current element is included in the solution
			TOWUtil(arr, n, curr_elements, no_of_selected, soln,
	                  min_diff, sum, curr_sum, curr_position+1);
		}
		// removes current element before returning to the caller of this function
		curr_elements[curr_position] = false;
		
	}

	public static void main(String[] args) {
		int[] t = new int[] {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		tugOfWar(t, t.length);
	}

}
