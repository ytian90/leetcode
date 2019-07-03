package backtracking;

import java.util.*;

/**
 * 425. Word Squares
 * @author yutian
 *
 */
public class WordSquares {

	public static List<List<String>> wordSquares(String[] words) {
		Map<String, Set<String>> map = new HashMap<>();
		for (String w : words) {
			for (int i = 1; i < w.length(); i++) {
				String prefix = w.substring(0, i);
				if (!map.containsKey(prefix)) {
					map.put(prefix, new HashSet<>());
				}
				map.get(prefix).add(w);
			}
		}
		List<List<String>> res = new ArrayList<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			list.add(words[i]);
			find(res, 1, list, map);
			list.remove(list.size() - 1);
		}
		return res;
	}

	public static void find(List<List<String>> res, int pos, List<String> list, Map<String, Set<String>> map) {
		if (list.size() == list.get(0).length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		String prefix = "";
		for (int i = 0; i < pos; i++) {
			prefix += list.get(i).charAt(pos);
		}
		if (!map.containsKey(prefix)) {
			return;
		}
		for (String word : map.get(prefix)) {
			list.add(word);
			find(res, pos + 1, list, map);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		System.out.println(wordSquares(new String[]{"abat","baba","atan","atal"}));
		System.out.println(wordSquares(new String[]{"buff","ulus","buns","rump","cuts","stum","murk","wuss","putt","pubs",
				"bust","chub","burp","bubs","suns","puns","buhr","ughs","mums","cunt","bhut","guff","pung","phut","flux",
				"snub","ruts","vugg","turd","hung","tups","xyst","puny","curr","curf","typy","busk","byrl","cusp","pups",
				"pulp","duns","dunk","tugs","dull","bury","murr","slum","mumm","jugs","burn","purl","curl","runt","spry",
				"typp","fugu","dunt","mump","cuds","juju","sudd","nuts","culm","dumb","gyps","buzz","surf","putz","tung",
				"tuns","puds","urns","tuck","duct","hugs","jump","bums","lulu","myth","rynd","undy","hunh","gulf","guts",
				"lutz","burl","lump","dung","gull","gush","bunk","tusk","dups","stub","gust","curs","juts","swum","luff",
				"subs","psst","syph","junk","funs","flub","hurt","burg","muck","buts","furl","such","mull","huff","chug",
				"kuru","dubs","guls","drum","bunt","blub","rhus","buss","hump","rust","stud","fund","cubs","plum","punk",
				"brut","cuff","sugh","wyns","pugh","cuss","buhl","hulk","burd","lurk","hymn","shun","yurt"}));
	}
	
	public static List<List<String>> wordSquares2(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
        	return res;
        }
        int len = words[0].length();
        Trie trie = new Trie(words);
        List<String> list = new ArrayList<>();
        for (String s : words) {
        	list.add(s);
        	helper(len, trie, res, list);
        	list.remove(list.size() - 1);
        }
        return res;
    }
	

	private static void helper(int len, Trie trie, List<List<String>> res, List<String> list) {
		if (list.size() == len) {
			res.add(new ArrayList<>(list));
			return;
		}
		int i = list.size();
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s.charAt(i));
		}
		List<String> startWith = trie.findByPrefix(sb.toString());
		for (String sw : startWith) {
			list.add(sw);
			helper(len, trie, res, list);
			list.remove(list.size() - 1);
		}
	}
	
	static class TrieNode {
		List<String> startWith;
		TrieNode[] children;
		
		TrieNode() {
			startWith = new ArrayList<>();
			children = new TrieNode[26];
		}
	}
	
	static class Trie {
		TrieNode root;
		
		Trie(String[] words) {
			root = new TrieNode();
			for (String w : words) {
				TrieNode curr = root;
				for (char ch : w.toCharArray()) {
					int i = ch - 'a';
					if (curr.children[i] == null)
						curr.children[i] = new TrieNode();
					curr.children[i].startWith.add(w);
					curr = curr.children[i];
				}
			}
		}
		
		List<String> findByPrefix(String prefix) {
			List<String> res = new ArrayList<>();
			TrieNode curr = root;
			for (char ch : prefix.toCharArray()) {
				int i = ch - 'a';
				if (curr.children[i] == null)
					return res;
				curr = curr.children[i];
			}
			res.addAll(curr.startWith);
			return res;
		}
	}

	// TLE my original solution, can't pass the longest test case
	//    public static List<List<String>> wordSquares(String[] words) {
//        List<List<String>> res = new ArrayList<>();
//        if (words.length == 0) {
//            return res;
//        }
//        int n = words.length, len = words[0].length();
//        List<String> list = new ArrayList<>();
//        helper(words, list, res, len);
//        return res;
//    }
//
//    public static void helper(String[] words, List<String> list, List<List<String>> res, int len) {
//        if (list.size() > len) {
//            return;
//        }
//        if (list.size() == len && isWordSquare(list)) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < words.length; i++) {
//            list.add(words[i]);
//            helper(words, list, res, len);
//            list.remove(list.size() - 1);
//        }
//    }
//
//    public static boolean isWordSquare(List<String> list) {
//        if (list == null || list.size() == 0) {
//            return true;
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = 0; j < list.get(0).length(); j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (list.get(i).charAt(j) != list.get(j).charAt(i)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
