package leetcode.binaryTree;

import java.util.*;

/**
 * 582. Kill Process
 * 
 * @author ytian
 *
 */
public class KillProcess {

	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		// Store process tree as an adjacency list
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < ppid.size(); i++) {
			map.putIfAbsent(ppid.get(i), new LinkedList<>());
			map.get(ppid.get(i)).add(pid.get(i));
		}

		// Kill all processes in the subtree rooted at process kill
		List<Integer> res = new ArrayList<>();
		Deque<Integer> stack = new ArrayDeque<>();
		stack.add(kill);
		while (!stack.isEmpty()) {
			int curr = stack.poll();
			res.add(curr);
			if (map.containsKey(curr)) {
				stack.addAll(map.get(curr));
			}
		}

		return res;
	}

	public static List<Integer> killProcees(List<Integer> pid, List<Integer> ppid, int kill) {
		if (kill == 0) return pid;
		int n = pid.size();
		Map<Integer, Set<Integer>> tree = new HashMap<>();
		for (int i = 0; i < n; i++) {
			tree.put(pid.get(i), new HashSet<>());
		}
		for (int i = 0; i < n; i++) {
			if (tree.containsKey(ppid.get(i))) {
				Set<Integer> children = tree.get(ppid.get(i));
				children.add(pid.get(i));
				tree.put(ppid.get(i), children);
			}
		}
		List<Integer> res = new ArrayList<>();
		traverse(tree, res, kill);
		return res;
	}

	private static void traverse(Map<Integer,Set<Integer>> tree, List<Integer> res, int pid) {
		res.add(pid);
		Set<Integer> children = tree.get(pid);
		for (Integer child : children) {
			traverse(tree, res, child);
		}
	}


	public static void main(String[] args) {
		System.out.println(killProcess(new ArrayList<>(Arrays.asList(1, 3, 10, 5)),
				new ArrayList<>(Arrays.asList(3, 0, 5, 3)), 5));

	}

}
