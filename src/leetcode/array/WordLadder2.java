package leetcode.array;

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
 * 126. Word Ladder II
 * @author yutian
 * @since Aug 22, 2015
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();

        set1.add(beginWord);
        set2.add(endWord);
        list.add(beginWord);

        helper(dict, set1, set2, map, false);
        generateList(beginWord, endWord, map, list, res);
        return res;
    }

    public boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
            return false;
        }
        if (set1.size() > set2.size()) {
            helper(dict, set2, set1, map, !flip);
        }

        dict.removeAll(set1);
        dict.removeAll(set2);

        boolean done = false;

        Set<String> set = new HashSet<>();

        for (String s : set1) {
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String word = new String(chars);
                    String key = flip ? word : s;
                    String value = flip ? s : word;

                    List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
                    if (set2.contains(word)) {
                        done = true;
                        list.add(value);
                        map.put(key, list);
                    }
                    if (!done && dict.contains(word)) {
                        set.add(word);
                        list.add(value);
                        map.put(key, list);
                    }
                }
            }
        }
        return done || helper(dict, set2, set, map, !flip);
    }

    public void generateList(String start, String end, Map<String, List<String>> map, List<String> list, List<List<String>> res) {
        if (start.equals(end)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (!map.containsKey(start)) {
            return;
        }
        for (String word : map.get(start)) {
            list.add(word);
            generateList(word, end, map, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordLadder2 t = new WordLadder2();
        System.out.println(t.findLadders("hot", "dog", new ArrayList<>(Arrays.asList
                ("hot","cog","dog","tot","hog","hop","pot","dot"))));
        System.out.println(t.findLadders("hit", "cog", new ArrayList<>(Arrays.asList
                ("hot","dot","dog","lot","log"))));
    }

    // method 2
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return res;
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        bfs(dict, begin, end, map);
        List<String> t = new ArrayList<>(Arrays.asList(beginWord));
        dfs(res, t, beginWord, endWord, map);
        return res;
    }

    private void bfs(Set<String> dict, Set<String> begin, Set<String> end, Map<String,List<String>> map) {
        boolean reversed = false;
        boolean terminated = false;
        while (begin.size() > 0) {
            dict.removeAll(begin);
            dict.removeAll(end);
            if (begin.size() > end.size()) {
                reversed = !reversed;
                Set<String> t = new HashSet<>(begin);
                begin = end;
                end = t;
            }
            Set<String> set = new HashSet<>();
            for (String s : begin) {
                for (int i = 0; i < s.length(); i++) {
                    char[] chars = s.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[i] == c) continue;
                        chars[i] = c;
                        String newStr = new String(chars);
                        if (end.contains(newStr)) {
                            if (!reversed) {
                                List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
                                list.add(newStr);
                                map.put(s, list);
                            } else {
                                List<String> list = map.containsKey(newStr) ? map.get(newStr) : new ArrayList<>();
                                list.add(s);
                                map.put(newStr, list);
                            }
                            terminated = true;
                        }
                        if (dict.contains(newStr)) {
                            if (!reversed) {
                                List<String> list = map.containsKey(s) ? map.get(s) : new ArrayList<>();
                                list.add(newStr);
                                map.put(s, list);
                            } else {
                                List<String> list = map.containsKey(newStr) ? map.get(newStr) : new ArrayList<>();
                                list.add(s);
                                map.put(newStr, list);
                            }
                            set.add(newStr);
                        }
                    }
                }
            }
            begin = set;
            if (terminated) return;
        }
    }

    private void dfs(List<List<String>> res, List<String> t, String start, String end, Map<String, List<String>> map) {
        if (start.equals(end)) {
            res.add(new ArrayList(t));
            return;
        }
        if (map.containsKey(start)) {
            for (String word : map.get(start)) {
                t.add(word);
                dfs(res, t, word, end, map);
                t.remove(t.size() - 1);
            }
        }

    }



	
	// Method 1 helper
	public List<List<String>> findLadders1(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>(); // add depth to avoid dead circle
        q.add(beginWord);
        map.put(beginWord, 1);
        
        int minDepth = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            String curr = q.poll();
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
                        q.add(next);
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
                    dfs(next, endWord, map, new ArrayList<>(path), res);
                }
            }
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
