package leetcode.dfs_bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 753. Cracking the Safe
 * @author ytian
 *
 */
public class CrackingTheSafe {
	public static String crackSafe(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int total = (int) (Math.pow(k, n));
		for (int i = 0; i < n; i++) {
			sb.append('0');
		}
		Set<String> visited = new HashSet<>();
		visited.add(sb.toString());
		helper(n, k, total, sb, visited);
		return sb.toString();
	}

	private static boolean helper(int n, int k, int total, StringBuilder sb, Set<String> visited) {
		if (visited.size() == total) {
			return true;
		}
		String prev = sb.substring(sb.length() - n + 1);
		for (int i = 0; i < k; i++) {
			String next = prev + i;
			if (visited.contains(next)) {
				continue;
			}
			visited.add(next);
			sb.append(i);
			if (helper(n, k, total, sb, visited)) {
				return true;
			}
			visited.remove(next);
			sb.deleteCharAt(sb.length() - 1);
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(crackSafe(1, 2));
		System.out.println(crackSafe(2, 2));
	}
}
