package string;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Shortest Snippet
 * Find shortest snippet，比如给一个Document是A,X,X,B,A,X,B，Query是A,B，要求返回shortestSnippet
	第一问：如果Query有序（即A一定要在B前面），那么要返回A,X,B. 1point3acres.com/bbs
	Follow incr：如果Query无序（即B在A前面也可以），那么要返回B,A
	再Follow incr：如果Document非常大，如何再优化？
	http://www.1point3acres.com/bbs/thread-127894-1-1.html
	https://shawnlincoding.wordpress.com/2015/04/08/shortest-snippet/
 * @author yutian
 * @since Feb 4, 2016
 */
public class ShortestSnippet {
	
	private static HashMap<String, ArrayList<Integer>> hashmap; // follow incr
	private static String[] document;
	
	public ShortestSnippet(String[] document) {
		if (document == null || document.length == 0) {
			throw new IllegalArgumentException();
		}
		this.document = document;
		hashmap = new HashMap<>();
		for (int i = 0; i < document.length; i++) {
			String word = document[i];
			if (!hashmap.containsKey(word)) {
				hashmap.put(word, new ArrayList<>());
			}
			hashmap.get(word).add(i);
		}
	}
	
	public static String query(String wordA, String wordB) {
		if (wordA == null || wordB == null) {
			throw new IllegalArgumentException();
		}
		if (!hashmap.containsKey(wordA) || !hashmap.containsKey(wordB)) {
			return "not found";
		}
		ArrayList<Integer> listA = hashmap.get(wordA);
		ArrayList<Integer> listB = hashmap.get(wordB);
		int i = 0, j = 0, minA = 0, minB = 0, minDist = Integer.MAX_VALUE;
		while (i < listA.size() && j < listB.size()) {
			if (listA.get(i) > listB.get(j)) {
				j++;
			} else {
				if (minDist > listB.get(j) - listA.get(i)) {
					minDist = listB.get(j) - listA.get(i);
					minA = listA.get(i);
					minB = listB.get(j);
				}
				i++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k = minA; k <= minB; k++) {
			sb.append(document[k]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static String query2(String wordA, String wordB) {
		if (wordA == null || wordB == null) {
			throw new IllegalArgumentException();
		}
		if (!hashmap.containsKey(wordA) || !hashmap.containsKey(wordB)) {
			return "not found";
		}
		ArrayList<Integer> listA = hashmap.get(wordA);
		ArrayList<Integer> listB = hashmap.get(wordB);
		int i = 0, j = 0, minA = 0, minB = 0, minDist = Integer.MAX_VALUE;
		while (i < listA.size() && j < listB.size()) {
			int posA = listA.get(i), posB = listB.get(j);
			if (minDist > Math.abs(posA - posB)) {
				minDist = Math.abs(posA - posB);
				minA = posA;
				minB = posB;
			}
			if (posA < posB) i++;
			else j++;
		}
		StringBuilder sb = new StringBuilder();
		int start = Math.min(minA, minB), end = Math.max(minA, minB);
		for (int k = start; k <= end; k++) {
			sb.append(document[k]);
			sb.append(" ");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] s = new String[]{"this", "is", "one", "of", "the", "best", "forum", "best", "one"};
		ShortestSnippet t = new ShortestSnippet(s);
		System.out.println(query("one", "best"));
		System.out.println(query2("one", "best"));
	}

}
