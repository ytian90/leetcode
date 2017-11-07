package array;

import java.util.HashSet;

/**
 * 
 * @author ytian
 *
 */
public class Elevator {
	
	public static int solution (int[] A, int[] B, int M, int X, int Y) {
		HashSet<Integer> set = new HashSet<>();
		int currPeople = 0, currWeight = 0, res = 1;
		for (int i = 0; i < A.length; i++) {
			currPeople++;
			currWeight += A[i];
			set.add(B[i]);
			if (currPeople == X || (i != A.length - 1 && currWeight + A[i + 1] > Y)) {
				res += set.size();
				currPeople = 0;
				currWeight = 0;
				res++;
				set.clear();
			}
		}
		if (set.size() > 0) res += set.size();
		return res;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[]{60, 80, 40}, new int[]{2, 3, 5}, 5, 2, 200));
		System.out.println(solution(new int[]{40, 40, 100, 80, 20}, new int[]{3, 3, 2, 2, 3}, 3, 5, 200));
	}

}
