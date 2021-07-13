package company.lnkin;

import java.util.*;

/**
 * LC 127. Word Ladder
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        int len = beginWord.length();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                char[] chars = curr.toCharArray();
                for (int j = 0; j < len; j++) {
                    char original_char = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original_char) continue;
                        chars[j] = c;
                        String next = new String(chars);
                        if (next.equals(endWord)) {
                            return res + 1;
                        }
                        if (dict.contains(next)) {
                            q.add(next);
                            dict.remove(next);
                        }
                    }
                    chars[j] = original_char;
                }
            }
            res++;
        }
        return 0;
    }
    /**
     * Time: O(N * 26 * M ^ 2) N is word list size, M is word length
     * Space: O(N * M ^ 2)
     */
}
