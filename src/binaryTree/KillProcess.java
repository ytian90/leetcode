package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args) {
		System.out.println(killProcess(new ArrayList<>(Arrays.asList(1, 3, 10, 5)),
				new ArrayList<>(Arrays.asList(3, 0, 5, 3)), 5));

	}

}
