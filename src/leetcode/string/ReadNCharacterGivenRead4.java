package leetcode.string;
/**
 * 157. Read N Characters Given Read4
 * @author yutian
 * @since Jul 26, 2015
 */

public class ReadNCharacterGivenRead4 extends Reader4 {
	
	/**
	 * 
	 * @param buf Destination buffer
	 * @param n Maximum number of characters to read
	 * @return The number of characters read
	 */
	public static int read(char[] buf, int n) {
		char[] buffer = new char[4];
		int ptr = 0; // total number of bytes
		boolean eof = false;
		while (!eof && ptr < n) {
			int sz = read4(buffer);
			if (sz < 4) eof = true;
			int bytes = Math.min(n - ptr, sz);
			System.arraycopy(buffer, 0, buf, ptr, bytes); 
			ptr += bytes;
		}
		return ptr;
	}
	
	// Solution 2
	public static int read2(char[] buf, int n) {
		int count = 0;
		char[] buf4 = new char[4];
		while (count < n) {
			int c = read4(buf4);
			for (int i = 0; i < Math.min(c, n - count); i++) {
				buf[count + i] = buf4[i];
			}
			count += Math.min(c, n - count);
			if (c < 4) break;
		}
		return count;
	}
	

	public static void main(String[] args) {
		System.out.println(read2("abc".toCharArray(), 4));
		System.out.println(read2("abcde".toCharArray(), 5));
	}

}
