package company.uuba.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * 4题 给一个字符串形式的二进制数，给一个query list，query有两种，'+'是把那个二进制数加一，'?'是在返回list中加入二进制字符串中'1'的个数
 * 比如说，input='1110'， query=[?,+,?,+,+,?]
 * return [3， 4， 2]
 */
public class QueryListCountOne {

    public static List<Integer> calculate(String binary, String query) {
        char[] binaryInt = binary.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (char c : query.toCharArray()) {
            if (c == '+') {
                binaryInt = plusOne(binaryInt);
            } else if (c == '?') {
                res.add(countOne(binaryInt));
            }
        }
        return res;
    }

    public static char[] plusOne(char[] binaryInt) {
        int n = binaryInt.length;
        int pos = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (binaryInt[i] == '0') {
                pos = i;
                break;
            }
        }
        if (pos == -1) {
            binaryInt = new char[binaryInt.length + 1];
            binaryInt[0] = '1';
            pos = 0;
        } else {
            binaryInt[pos] = '1';
        }
        for (int i = pos + 1; i < n; i++) {
            binaryInt[i] = '0';
        }
        return binaryInt;
    }

    private static int countOne(char[] binaryInt) {
        int res = 0;
        for (char c : binaryInt) {
            if (c == '1') res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1110", "?+?++?"));
    }

}
