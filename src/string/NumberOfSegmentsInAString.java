package string;
/**
 * 434. Number of Segments in a String
 * @author ytian
 *
 */
public class NumberOfSegmentsInAString {
	
	public static int countSegments(String s) {
        if (s == null || s.isEmpty()) return 0;
        int n = s.length(), count = 0;
        boolean inWord = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                inWord = true;
                continue;
            } else {
                if (inWord) count++;
                inWord = false;
            }
        }
        if (inWord) count++;
        return count;
    }

	public static void main(String[] args) {
//		System.out.println(countSegments("Hello, my name is John"));
		System.out.println(11 / 2);
	}

}
