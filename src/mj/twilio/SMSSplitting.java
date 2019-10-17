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

    public static void segmentMessage(String message) {
        List<String> res = new ArrayList<>();
        int row = 0, start = 0, end = 154;
        if (message.length() <= 160) {
            res.add(message);
            System.out.println(message);
            return;
        }
        while (end < message.length()) {
            if (message.charAt(end + 1) != ' ') {
                while (start <= end && message.charAt(end) != ' ') {
                    end--;
                }
            }
            res.add(message.substring(start, end));
            start = end;
            end = start + 154;
            row += 1;
        }
        res.add(message.substring(start));
        row++;
        for (int i = 0; i < row; i++) {
            String s = res.get(i) + "(" + (i + 1) + "/" + row + ")";
            System.out.println(s.length());
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        String s = "njdksjfn jdfnds kjfdklsjf jsdofjsd f jdslkjfgdslkngdslkjg fljksdjflsfdsjfdslkfjdslkfmdsklmfgn ljsdglkdsfg d lkjgdslkgjdsljgdslkjgdsfjngds lkjsdlkgjdsgkldsjgsdlkg lkjdslkgjdslkgjdslgmnds glkjgdslkjgdslkjfgodsjfds g,mdsgkjdsngdlsknfgldsjfglkdsjfglkdsjglkdsjglkdsgjdsklgjdslk lkgjdslkgfjdslkgjdslkgjdsljfgdslkgjmdslkg kljghjdslkjgdslkjfg";
//        System.out.println(s.length());
//        System.out.println(segmentMessage(s));
        segmentMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consequat nec dui quis maximus. Praesent vehicula feugiat condimentum. Nunc porta vulputate elit sit amet lacinia. Vivamus volutpat accumsan consequat. Nulla mattis odio erat, vel convallis neque semper nec. Integer a pharetra purus.");
        segmentMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consequat nec dui quis maximus. Praesent vehicula feugiat condimentum. Nunc portamludimi vulputate elit sit amet lacinia. Vivamus volutpat accumsan consequat. Nulla mattis odio erat, vel convallis neque semper nec. Integer a pharetra purus.");
        segmentMessage("lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europe lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.");
    }
}
