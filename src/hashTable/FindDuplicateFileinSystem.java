package hashTable;

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
	
	public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        int n = paths.length;
        if (n == 0) return res;
        
        Map<String, Set<String>> map = new HashMap<>();
        for (String path: paths) {
        	String[] strs = path.split("\\s+");
        	for (int i = 1; i < strs.length; i++) {
        		int index = strs[i].indexOf("(");
        		String content = strs[i].substring(index);
        		String filename = strs[0] + "/" + strs[i].substring(0, index);
        		Set<String> filenames = map.getOrDefault(content, new HashSet<String>());
        		filenames.add(filename);
        		map.put(content, filenames);
        	}
        }
        for (String key : map.keySet()) {
        	if (map.get(key).size() > 1) {
        		res.add(new ArrayList<String>(map.get(key)));
        	}
        }
        return res;
    }
	
	public static List<List<String>> findDuplicate2(String[] paths) {
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
	
	public static void main(String[] args) {
		String[] test = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
		for (List<String> l : findDuplicate(test)) {
			System.out.println(l);
		}
	}

}
