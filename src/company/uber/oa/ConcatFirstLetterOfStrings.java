package company.uber.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * input: {"apple","pen","car","class"} ,输出首尾字母连接就行，最后一个连第一个：output:{"ap","pc","cc","ca"}
 */
public class ConcatFirstLetterOfStrings {
    public static List<String> concat(List<String> words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.size() == 0) {
            return res;
        }
        int n = words.size();
        for (int i = 1; i <= n; i++) {
            String s = "";
            res.add(s + words.get(i - 1).charAt(0) + words.get(i % n).charAt(0));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(concat(Arrays.asList("apple", "pen", "car", "class")));
    }
}
