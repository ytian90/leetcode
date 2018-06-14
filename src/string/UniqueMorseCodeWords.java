package string;

import java.util.HashSet;

/**
 * 804。 Unique Morse Code Words
 */
public class UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] dict = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            String res = "";
            for (char c : word.toCharArray()) res += dict[c - 'a'];
            set.add(res);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
