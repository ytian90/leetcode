package string;
/**
 * 686. Repeated String Match
 * @author ytian
 *
 */
public class RepeatedStringMatch {
	
	public static int repeatedStringMatch(String A, String B) {
        int i = 0, j = 0;
        while (i < A.length()) {
            j = 0;
            while (j < B.length() && A.charAt((i + j) % A.length()) == B.charAt(j)) {
                j++;
            }
            if (j == B.length()) {
                if ((i + j) % A.length() == 0) {
                    return (i + j) / A.length();
                } else {
                    return (i + j) / A.length() + 1;
                }
            }
            i++;
        }
        return -1;
    }

	public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
	}

}
