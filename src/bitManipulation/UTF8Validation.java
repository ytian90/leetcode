package bitManipulation;
/**
 * 393. UTF-8 Validation
 * @author yutian
 * @since Sep 5, 2016
 */
public class UTF8Validation {
	
	public boolean validUtf8(int[] data) {
        int n = data.length;
        if (n == 0) return true;
        int skip = 0b10000000, check = 0;
        for (int i = 0; i < data.length; i++) {
        	if (check > 0) {
        		if ((data[i] & skip) == skip) check--;
        		else return false;
        	} else {
        		check = getOneBitCountFromHead(data[i]);
        		if (check < 0) return false;
        	}
        }
        return check == 0;
    }
	

	private int getOneBitCountFromHead(int num) {
		if ((num & 0b11110000) == 0b11110000) return 3;
        if ((num & 0b11100000) == 0b11100000) return 2;
        if ((num & 0b11000000) == 0b11000000) return 1;
        if ((num & 0b10000000) == 0b10000000) return -1; //error
        return 0;
	}


	public static void main(String[] args) {

	}

}
