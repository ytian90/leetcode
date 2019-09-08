package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 609. Find Duplicate File in System
 * @author ytian
 *
 */
public class FindDuplicateFileinSystem {
	static final String ss = "/";

	public static List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> res = new ArrayList<>();
		if (paths.length == 0) {
			return res;
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : paths) {
			cleanUpData(s, map);
		}
		for (List<String> l : map.values()) {
			if (l.size() > 1) {
				res.add(l);
			}
		}
		return res;
	}

	public static void cleanUpData(String s, Map<String, List<String>> map) {
		if (s == null || s.length() == 0) {
			return;
		}
		String[] strArr = s.split(" ");
		int n = strArr.length;
		if (n < 2) {
			return;
		}
		for (int i = 1; i < n; i++) {
			StringBuilder sb = new StringBuilder(strArr[0]);
			sb.append(ss);
			int index = strArr[i].indexOf('(');
			if (index == -1) {
				continue;
			}
			sb.append(strArr[i].substring(0, index));
			int endIndex = strArr[i].indexOf(')');
			String content = strArr[i].substring(index, endIndex);
			if (!map.containsKey(content)) {
				map.put(content, new ArrayList<>());
			}
			map.get(content).add(sb.toString());
		}
	}

	public static void main(String[] args) {
        System.out.println(findDuplicate(new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
        }));

		System.out.println(findDuplicate(new String[]{
				"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"
		}));
	}

	public static List<List<String>> findDuplicate2(String[] paths) {
		List<List<String>> res = new ArrayList<>();
		int n = paths.length;
		if (n == 0) return res;

		Map<String, Set<String>> map = new HashMap<>();
		for (String path: paths) {
			String[] strs = path.split(" "); // path.split("\\s+");
			for (int i = 1; i < strs.length; i++) {
				int index = strs[i].indexOf("(");
				String content = strs[i].substring(index);
				String filename = strs[0] + "/" + strs[i].substring(0, index);
				Set<String> set = map.getOrDefault(content, new HashSet<>());
				set.add(filename);
				map.put(content, set);
			}
		}
		for (String key : map.keySet()) {
			if (map.get(key).size() > 1) {
				res.add(new ArrayList<>(map.get(key)));
			}
		}
		return res;
	}
	
	public static List<List<String>> findDuplicate3(String[] paths) {
		Map<String, List<String>> map = new HashMap<>();
		for (String path : paths) {
			String[] tokens = path.split(" ");
			for (int i = 1; i < tokens.length; i++) {
				String file = tokens[i].substring(0, tokens[i].indexOf('('));
				String content = tokens[i].substring(tokens[i].indexOf('(') + 1, tokens[i].indexOf(')'));
				map.putIfAbsent(content, new ArrayList<>());
				map.get(content).add(tokens[0] + "/" + file);
			}
		}
		return map.values().stream().filter(e -> e.size() > 1).collect(Collectors.toList());
	}

}
