package math;

import java.util.HashMap;
import java.util.Map;

/**
 * 246. Strobogrammatic Number
 * @author yutian
 * @since Dec 27, 2015
 */
public class StrobogrammaticNumber {
	
	public static boolean isStrobogrammatic(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        for (int i = 0; i <= len / 2; i++) {
            if (arr[i] == arr[len - 1 - i] &&
            		(arr[i] == '0' || arr[i] == '1' || arr[i] == '8')) {
                continue;
            } else if ((arr[i] == '6' && arr[len - 1 - i] == '9') 
            		|| (arr[i] == '9' && arr[len - 1 - i] == '6')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isStrobogrammaticc(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int n = num.length();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(num.charAt(i))) {
                if (num.charAt(n - 1 -i) != map.get(num.charAt(i))) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }


	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("6"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("868"));
	}

}
