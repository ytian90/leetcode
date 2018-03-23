package dfs_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock
 * @author ytian
 *
 */
public class OpenTheLock {
	
	public static int openLock(String[] deadends, String target) {
		Set<String> begin = new HashSet<>();
		Set<String> end = new HashSet<>();
		Set<String> deads = new HashSet<>(Arrays.asList(deadends));
		begin.add("0000");
		end.add(target);
		int level = 0;
		while (!begin.isEmpty() && !end.isEmpty()) {
			Set<String> t = new HashSet<>();
			for (String s : begin) {
				if (end.contains(s)) return level;
				if (deads.contains(s)) continue;
				deads.add(s);
				StringBuilder sb = new StringBuilder(s);
				for (int i = 0; i < 4; i++) {
					char c = sb.charAt(i);
					String s1 = sb.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + sb.substring(i + 1);
					String s2 = sb.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + sb.substring(i + 1);
					if (!deads.contains(s1)) {
						t.add(s1);
					}
					if (!deads.contains(s2)) {
						t.add(s2);
					}
				}
			}
			level++;
			begin = end;
			end = t;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
		System.out.println(openLock(new String[] {"8888"}, "0009"));
		System.out.println(openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
		System.out.println(openLock(new String[] {"0000"}, "8888"));
	
	}

}
