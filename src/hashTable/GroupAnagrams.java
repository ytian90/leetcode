package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 * @author yutian
 * @since Aug 18, 2015
 */
public class GroupAnagrams {
	// Solution 2 faster more concise Time ~O(NlogN), Space ~O(N)
	public static List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(strs);
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch);
			if (map.containsKey(s)) {
				List<String> li = result.get(map.get(s));
				li.add(str);
			} else {
				List<String> li = new ArrayList<>();
				li.add(str);
				result.add(li);
				map.put(s, result.size() - 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams2(test);
		for (List<String> l: result) {
			System.out.println(l);
		}
	}
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			// String sortWord = sortStr(s);
			String sortWord = labelStr(s); // faster
			if (!map.containsKey(sortWord)) {
				map.put(sortWord, new ArrayList<String>());
			}
			map.get(sortWord).add(s);
		}
		List<List<String>> list = new ArrayList<>();
		for (List<String> listWord : map.values()) {
			if (listWord.size() > 0) {
				Collections.sort(listWord);
				list.add(listWord);
			}
		}
		return list;
	}
	/**
	 * convert "apple" to "aelpp": O(NlogN)
	 * @param s
	 * @return
	 */
	private String sortStr(String s) {
		char[] word = s.toCharArray();
		Arrays.sort(word);
		return new String(word);
	}

	/**
	 * convert "apple" to "a1e1l1p2" => "971101110811122": O(N)
	 * @param s
	 * @return
	 */
	private String labelStr(String s) {
		int[] count = new int[256];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i)]++;
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 256; i++) {
			if (count[i] > 0) str.append(i).append(count[i]);
		}
		return str.toString();
		
	}
	

	
	
}
