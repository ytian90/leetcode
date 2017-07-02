package hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MuleSoft_2 {
	
	public static int solution2(int[] A) {
		List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for (int i = 0; i < A.length; i++) {
        	list.add(new HashSet<>());
        	dfs(list.get(i), A[i], A);
        }
        int result = 0;
        for (HashSet<Integer> h: list) {
        	result = Math.max(result, h.size());
        }
        return result;
	}

	private static void dfs(HashSet<Integer> set, int target, int[] A) {
		if (set.contains(target)) return;
		set.add(target);
		dfs(set, A[target], A);
	}
	
	
	public static int solution(int[] A) {
		int n = A.length, result = 0;
		int[] roots = new int[n];
		for (int i = 0; i < n; i++) roots[i] = i;
		for (int i = 0; i < n; i++) {
			int root1 = find(roots, i);
			int root2 = find(roots, A[i]);
			if (root1 != root2) {
				roots[root2] = root1;
			}
		}
		for (int i: roots) {
			System.out.print(i + " ");
			
		}
		System.out.println();
		
		int target = 0, count = 0;
        for (int i = 0; i < roots.length; i++) {
            if (count == 0) {
            	target = roots[i];
                count = 1;
            } else if (target == roots[i]) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(target);
        for (int c: roots) {
        	if (c == target) result++;
        }
        return result;
	}

	private static int find(int[] roots, int i) {
		while (roots[i] != i) {
			roots[i] = roots[roots[i]];
			i = roots[i];
		}
		return i;
	}

	public static void main(String[] args) {
		int[] t = new int[]{5, 4, 0, 3, 1, 6, 2};
		System.out.println(solution(t));
	}

}
