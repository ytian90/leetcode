package company.apple;

/**
 * https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=749652&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D4%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
 */
public class ReadNCharactersGivenRead5_CallMultipleTimes {
    private int bufferPointer = 0;
    private int bufferCounter = 0;
    private char[] buffer = new char[5];

    public int read(char[] buff, int n) {
        int pointer = 0;
        while (pointer < n) {
            if (bufferPointer == 0) {
                bufferCounter = read5(buffer);
            }
            if (bufferCounter == 0) break;
            while (pointer < n && bufferPointer < bufferCounter) {
                buff[pointer++] = buffer[bufferPointer++];
            }
            if (bufferPointer >= bufferCounter) {
                bufferPointer = 0;
            }
        }
        return pointer;
    }

    private int read5(char[] buf5) {
        return 0;
    }

}
