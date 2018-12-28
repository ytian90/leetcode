package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 929. Unique Email Addresses
 */
public class UniqueEmailAddress {

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        if (emails == null || emails.length == 0)
            return 0;
        for (String email : emails) {
            String[] arr = email.split("@");
            if (arr[0].contains("+")) {
                String[] f = arr[0].split("\\+");
                arr[0] = f[0];
            }
            arr[0] = arr[0].replaceAll("[.]", "");
            set.add(arr[0] + arr[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        }));

    }
}
