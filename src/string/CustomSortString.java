package string;

/**
 * 791. Custom Sort String
 */
public class CustomSortString {

    public static String customSortString(String S, String T) {
        int[] bucket = new int[26];
        for (char c : T.toCharArray()) {
            bucket[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            while (bucket[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}
