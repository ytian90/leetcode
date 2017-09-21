package math;
/**
 * 504. Base 7
 * @author ytian
 *
 */
public class Base7 {
	
	public static String convertToBase7(int num) {
        if (num < 0) {
        	return '-' + convertToBase7(-num);
        }
        if (num < 7) {
        	return num + "";
        }
        return convertToBase7(num / 7) + num % 7;
    }
	
	public static String convertToBase71(int num) {
		return Integer.toString(num, 7);
	}

	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
		System.out.println(convertToBase7(-7));
	}

}
