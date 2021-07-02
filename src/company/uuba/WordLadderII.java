package company.uuba;

import java.util.*;

/**
 * LC 126. Word Ladder II
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        buildGraph(beginWord, endWord, graph, dict);
        dfs(beginWord, endWord, graph, path, res);
        return res;
    }

    private void buildGraph(String beginWord, String endWord, Map<String, List<String>> graph, Set<String> dict) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        visited.add(beginWord);
        q.add(beginWord);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            Set<String> nextVisit = new HashSet<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                List<String> nextWords = getNextWord(word, dict);
                for (String next : nextWords) {
                    if (next.equals(endWord)) {
                        found = true;
                    }
                    if (!visited.contains(next)) {
                        if (!graph.containsKey(word)) {
                            graph.put(word, new ArrayList<>());
                        }
                        graph.get(word).add(next);
                        if (!nextVisit.contains(next)) {
                            q.add(next);
                            nextVisit.add(next);
                        }
                    }
                }
            }
            visited.addAll(nextVisit);
        }
    }

    private List<String> getNextWord(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (chars[i] == c) continue;
                char t = chars[i];
                chars[i] = c;
                String next = new String(chars);
                if (dict.contains(next)) {
                    res.add(next);
                }
                chars[i] = t;
            }
        }
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> graph, List<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (graph.containsKey(beginWord)) {
            for (String next : graph.get(beginWord)) {
                path.add(next);
                dfs(next, endWord, graph, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * Time: O(N * K ^ 2 + a), where N is the number of words in wordList,
     * K is the maximum length o a word, a is the number of possible paths from
     * beginWord to endWord in the directed graph we have.
     * Space: O(N * K)
     */
}
