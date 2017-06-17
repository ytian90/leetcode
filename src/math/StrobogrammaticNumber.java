package math;
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

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("69"));
		System.out.println(isStrobogrammatic("6"));
		System.out.println(isStrobogrammatic("88"));
		System.out.println(isStrobogrammatic("868"));
	}

}
