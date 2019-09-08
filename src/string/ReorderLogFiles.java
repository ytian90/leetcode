package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 937. Reorder Log Files
 */
public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1i = s1.indexOf(' ');
                int s2i = s2.indexOf(' ');
                char s1c = s1.charAt(s1i + 1);
                char s2c = s2.charAt(s2i + 1);
                if (s1c <= '9') {
                    if (s2c <= '9') {
                        return 0;
                    } else return 1;
                }
                if (s2c <= '9') return -1;

                int pref = s1.substring(s1i + 1).compareTo(s2.substring(s2i + 1));
                if (pref == 0) return s1.substring(0, s1i).compareTo(s2.substring(0, s2i));
                return pref;
            }
        };

        Arrays.sort(logs, comp);
        return logs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{
                "a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"
        })));
    }
}
