package hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 249. Group Shifted Strings
 * @author yutian
 * @since Dec 27, 2015
 */
public class GroupShiftedStrings {
	
	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str: strings) {
			int offset = str.charAt(0) - 'a';
			String key = "";
			for (int i = 0; i < str.length(); i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') c += 26;
				key += c;
			}
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		for (String key: map.keySet()) {
			List<String> list = map.get(key);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] t = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		String[] t2 = new String[]{"az", "yx"}; // for c += 26
		List<List<String>> res = groupStrings(t2);
		for (List<String> r: res) {
			System.out.println(r);
		}
	}

}
