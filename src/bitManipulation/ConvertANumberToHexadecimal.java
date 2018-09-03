package bitManipulation;
/**
 * 405. Convert a Number to Hexadecimal
 * @author yutian
 *
 */
public class ConvertANumberToHexadecimal {
	
	static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
			'a', 'b', 'c', 'd', 'e', 'f'};
	
	public static String toHex(int num) {
		if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 15]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		System.out.println(toHex(-1));
		System.out.println(toHex(26));
	}

}
