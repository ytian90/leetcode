package mj.twilio;

import java.util.ArrayList;
import java.util.List;

/**
 * Input is a string of characters that represents a text message. You need to segment this message into chunks of
 * messages each of length 160 characters and add suffix "(1/5)" (representing pagination) at the end of each
 * segmented message (Length of "(1/5)" is included in 160 length limit).
 *
 * Input: "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg"
 *
 * Output: ['njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds (1/3)', 'lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk (2/3)', 'lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg(3/3)']
 *
 * Bonus Points: Pass the large test cases of question 3 without using split() function.
 *
 * https://leetcode.com/discuss/interview-question/394697/Twilio-or-OA-2019
 * https://www.1point3acres.com/bbs/thread-560080-1-1.html
 */
public class SMSSplitting {

    public static List<String> segmentMessage(String message) {
        List<String> res = new ArrayList<>();
        int row = 0, start = 0, end = 154;
        if (message.length() <= 160) {
            res.add(message);
            return res;
        }
        while (end < message.length()) {
            if (message.charAt(end) != ' ') {
                while (start <= end && message.charAt(end) != ' ' && message.charAt(end - 1) != ' ') {
                    end--;
                }
            }
            res.add(message.substring(start, end));
            start = end + 1;
            end = start + 154;
            row += 1;
        }
        res.add(message.substring(start));
        row++;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ans.add(res.get(i) + "(" + (i + 1) + "/" + row + ")");
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";
        System.out.println(s.length());
        System.out.println(segmentMessage(s));
    }
}
