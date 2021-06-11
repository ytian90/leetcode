package company.lnkin;

/**
 * LC 243. Shortest Word Distance
 *
 * Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2,
 * return the shortest distance between these two words in the list.
 *
 * Example 1:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
 * Output: 3
 * Example 2:
 *
 * Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
 * Output: 1
 */
public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int a = -1, b = -1, res = Integer.MAX_VALUE / 2;
        for (int i = 0; i < wordsDict.length; i++) {
            String w = wordsDict[i];
            if (w.equals(word1)) {
                a = i;
                if (b != -1) {
                    res = Math.min(res, Math.abs(a - b));
                }
            }
            if (w.equals(word2)) {
                b = i;
                if (a != -1) {
                    res = Math.min(res, Math.abs(a - b));
                }
            }
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
