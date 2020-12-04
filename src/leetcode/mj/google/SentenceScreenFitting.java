package leetcode.mj.google;

/**
 * 418. Sentence Screen Fitting
 */
public class SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start - 1) % l) != ' ') {
                    start--;
                }
            }
        }
        return start / l;
    }

    public static void main(String[] args) {
        System.out.println(wordsTyping(new String[]{"hello", "world"}, 2, 8));
        System.out.println(wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6));
        System.out.println(wordsTyping(new String[]{"I", "had", "apple", "pie"}, 4, 5));
        System.out.println(wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
        System.out.println(wordsTyping(new String[]{"a", "b", "c"}, 3, 1));
        System.out.println(wordsTyping(new String[]{"a"}, 20000, 20000)); // TLE
    }

    // work but TLE
    public static int wordsTyping1(String[] sentence, int rows, int cols) {
        int currR = 0, currC = 0, count = 0, index = 0;
        while (currR < rows) {
            if (index == sentence.length) {
                count++;
                index %= sentence.length;
            }
            int toFit = (currC > 0 ? 1 : 0) + sentence[index].length() ;
            if (currC + toFit <= cols) {
                currC += toFit;
                if (currC == cols) {
                    currR++;
                    currC = 0;
                }
            } else {
                currR++;
                currC = 0;
                index--;
            }
            index++;
        }
        return (index == sentence.length) ? count + 1 : count;
    }

}
