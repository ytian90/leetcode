package leetcode.mj.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 4. Guess Word
 */
public class GuessWord {
    public void findSecretWord(String[] wordList, Master master) {
        for (int i = 0, guess = 0; i < 10 && guess < 6; i++) {
            Map<String, Integer> count = new HashMap<>();
            for (String w1 : wordList) {
                for (String w2 : wordList) {
                    if (match(w1, w2) == 0) {
                        count.put(w1, count.getOrDefault(w1, 0) + 1);
                    }
                }
            }
            Pair minimax = new Pair("", 1000);
            for (String w : wordList) {
                if (count.getOrDefault(w, 0) < minimax.freq) {
                    minimax.key = w;
                    minimax.freq = count.getOrDefault(w, 0);
                }
            }
            guess = master.guess(minimax.key);
            List<String> next = new ArrayList<>();
            for (String w : wordList) {
                if (match(minimax.key, w) == guess) {
                    next.add(w);
                }
            }
            wordList = next.toArray(new String[next.size()]);
        }
    }

    private int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }

    private static class Pair {
        String key;
        int freq;
        public Pair(String key, int freq) {
            this.key = key;
            this.freq = freq;
        }
    }

    private interface Master {
        int guess(String word);
    }
}
