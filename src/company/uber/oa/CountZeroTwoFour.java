package company.uber.oa;

/**
 * count occurance 数从0到n中，digit 0， 2， 4 一共出现了多少次。例如n=22， 0 出现了（0，10，20）3次，2出现了（2，12，20，21，22）6次，4出现了（4，14）2次，所以一共是11次
 * https://leetcode.com/discuss/interview-question/1113153/Uber-OA-2021-CodeSignal/880331
 */
public class CountZeroTwoFour {
    private static int countAllOccurance(int n) {
        int res = 0;
        while (n > 0) {
            int remind = n % 10;
            if (remind == 0 || remind == 2 || remind == 4) {
                res++;
            }
            n /= 10;
        }
        return res;
    }

    public static int count(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res += countAllOccurance(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count(22));
    }

}
