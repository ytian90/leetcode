package string;
/**
 * 158. Read N Characters Given Read4 II - Call multiple times
 * @author yutian
 * @since Feb 6, 2016
 */
public class ReadNCharactersGivenRead42 extends Reader4 {
	
	/*
	 * I used buffer pointer (buffPtr) and buffer Counter 
	 * (buffCnt) to store the data received in previous calls. 
	 * In the while loop, if buffPtr reaches current buffCnt, 
	 * it will be set as zero to be ready to read new data.
	 */
	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];
	
	public int read(char[] buf, int n) {
		int ptr = 0;
		while (ptr < n) {
			if (buffPtr == 0) {
	            buffCnt = read4(buff);
	        }
	        while (ptr < n && buffPtr < buffCnt) {
	            buf[ptr++] = buff[buffPtr++];
	        }
	        // all chars in buff used incr, set pointer to 0
	        if (buffPtr == buffCnt) buffPtr = 0;
	        // read4 returns less than 4, end of file
	        if (buffCnt < 4) break;
		}
		return ptr;
	}
	
	/*
	 * Think that you have 4 chars "a, b, c, d" in the file, 
	 * and you want to call your function twice like this:
	 * read(buf, 1); // should return 'a'
	 * read(buf, 3); // should return 'b, c, d'
	 * All the 4 chars will be consumed in the first call. 
	 * So the tricky part of this question is how can you 
	 * preserve the remaining 'b, c, d' to the second call.
	 */

	public static void main(String[] args) {

	}

}
