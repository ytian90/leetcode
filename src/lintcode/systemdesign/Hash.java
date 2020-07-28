package lintcode.systemdesign;

/**
 * 128. 哈希函数
 */
public class Hash {
    public static int hashCode(char[] key, int HASH_SIZE) {
        if (key == null || key.length == 0) {
            return 0;
        }
        int baseNum = 33;
        double res = 0;
        for (int i = 0; i < key.length; i++) {
            int charNum = (int) key[i];
            res = (res * baseNum + charNum) % HASH_SIZE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(hashCode("ubuntu".toCharArray(), 1007));
    }
}
