package dfs_bfs;

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
		dfs(sb, total, visited, n, k);
		return sb.toString();
	}
	
	private static boolean dfs(StringBuilder sb, int total, Set<String> visited, int n, int k) {
		if (visited.size() == total) {
			return true;
		}
		String prev = sb.substring(sb.length() - n + 1, sb.length());
		for (int i = 0; i < k; i++) {
			String next = prev + i;
			if (!visited.contains(next)) {
				visited.add(next);
				sb.append(i);
				if (dfs(sb, total, visited, n, k)) {
					return true;
				} else {
					visited.remove(next);
					sb.deleteCharAt(sb.length() - 1);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(crackSafe(1, 2));
		System.out.println(crackSafe(2, 2));
	}

}
