package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder II
 * @author yutian
 * @since Aug 22, 2015
 */
public class WordLadder2 {
	
	// Method 1 dfs
	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> words = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>(); // add depth to avoid dead circle
        words.add(beginWord);
        map.put(beginWord, 1);
        
        int minDepth = Integer.MAX_VALUE;
        while (!words.isEmpty()) {
            String curr = words.poll();
            int depth = map.get(curr);
            if (depth >= minDepth) continue;
            if (curr.equals(endWord)) {
                minDepth = Math.min(minDepth, depth);
                continue;
            }
            for (int i = 0; i < curr.length(); i++) {
                char[] arr = curr.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                	arr[i] = c;
                    String next = new String(arr);
                    if (wordList.contains(next) && !map.containsKey(next)) {
                        words.add(next);
                        map.put(next, depth + 1);
                    }
                }
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> path = new ArrayList<>();
        dfs(endWord, beginWord, map, path, res);
        return res;
    }
    
    private void dfs(String beginWord, String endWord, Map<String, Integer> map, 
    		List<String> path, List<List<String>> res) {
        if (!map.containsKey(beginWord)) return;
        path.add(beginWord);
        if (beginWord.equals(endWord)) {
            Collections.reverse(path);
            res.add(path);
            return;
        }
        int depth = map.get(beginWord) - 1;
        for (int i = 0; i < beginWord.length(); i++) {
            char[] arr = beginWord.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                String next = new String(arr);
                if (map.containsKey(next) && map.get(next) == depth) {
                    dfs(next, endWord, map, new ArrayList<String>(path), res);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	WordLadder2 t = new WordLadder2();
//    	Set<String> set1 = new HashSet<String>(Arrays.asList
//    			("hot","cog","dog","tot","hog","hop","pot","dot"));
//    	
//    	for (List<String> l : t.findLadders("hot", "dog", set1)) {
//    		System.out.println(l);
//    	}
    	
    	Set<String> set2 = new HashSet<String>(Arrays.asList("a", "b", "c"));
    	
    	for (List<String> l : t.findLadders("a", "c", set2)) {
    		System.out.println(l);
    	}
    	
    }
    
    // Method 2 bfs too slow
 	public List<List<String>> findLadders2(String beginWord, String endWordWord, Set<String> wordList) {
 		List<List<String>> res = new ArrayList<>();
 		Queue<List<String>> q = new LinkedList<>();
 		q.add(Arrays.asList(endWordWord));
 		wordList.remove(endWordWord);
 		while (!q.isEmpty() && res.size() == 0) {
 			int size = q.size();
 			HashSet<String> set = new HashSet<>(wordList);
 			for (int i = 0; i < size; i++) {
 				List<String> curr = q.remove();
 				String s = curr.get(curr.size() - 1);
 				for (int j = 0; j < s.length(); j++) {
 					for (char c = 'a'; c <= 'z'; c++) {
 						List<String> list = new ArrayList<>(curr);
 						char[] chars = s.toCharArray();
 						if (c != chars[j]) {
 							chars[j] = c;
 							String next = new String(chars);
 							if (next.equals(beginWord)) {
 								list.add(next);
 								Collections.reverse(list);
 								res.add(list);
 							} else if (set.contains(next)) {
 								list.add(next);
 								q.add(list);
 								wordList.remove(next);
 							}
 						}
 					}
 				}
 			}
 		}
 		return res;
 	}
 	
 	
 	
	
}
