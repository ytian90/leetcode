package mj.linkedin;

import java.io.CharConversionException;
import java.util.*;

/**
 Question;
 第三题：205的follow incr，给一个string数组，将iso的词归在一组 {'fff','abc','foo','haa','www','vvv'}-> { {'fff','www','vvv'} , {'haa','foo'} , {'abc'} }


 Solution:
 借了group anagram的方法把所有的string都换成a开头的iso string，然后用hashmap<String,Set<String>>解了。

 transfer word into same isomorphic partten
 every word start with 'a', every time meet a new letter
 map it to cur char, and increase the value of cur char the then if same letter show incr again, use the value in map
 ex. foo -> abb
 ex. gjk -> abc
 ex. pkk -> abb
 */
public class Find_Isomorphic {
    public static List<List<String>> findIsomorphic(String[] input) {
        Map<String, Set<String>> wordToIso = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String word : input) {
            String curr = transfer(word);
            if (!wordToIso.containsKey(curr)) {
                wordToIso.put(curr, new HashSet<>());
            }
            wordToIso.get(curr).add(word);
        }

        for (String iso : wordToIso.keySet()) {
            res.add(new ArrayList<>(wordToIso.get(iso)));
        }
        return res;
    }

    private static String transfer(String word) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        char curr = 'a';
        for (char letter : word.toCharArray()) {
            if (!map.containsKey(letter)) {
                map.put(letter, curr);
                curr++;
            }
            sb.append(map.get(letter));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] t = new String[]{"fff","abc","foo","haa","www","vvv"};
        System.out.println(findIsomorphic(t));
    }
}
