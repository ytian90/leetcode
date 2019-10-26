package minimax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 843. Guess the Word
 */
public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; i++) {
            String guessWord = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guessWord);
            List<String> next = new ArrayList<>();
            for (String s : wordlist) {
                if (match(guessWord, s) == x) {
                    next.add(s);
                }
            }
            wordlist = next.toArray(new String[next.size()]);
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

    private interface Master {
        int guess(String word);
    }
}
