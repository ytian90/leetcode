package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 * @author yutian
 * @since Jan 16, 2016
 */
public class EncodeAndDecodeStrings {
	
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) {
        	sb.append(s.length()).append('*').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
        	int sl = s.indexOf('*', i);
        	int size = Integer.valueOf(s.substring(i, sl));
        	result.add(s.substring(sl + 1, sl + size + 1));
        	i = sl + size + 1;
        }
        return result;
    }
	

	public static void main(String[] args) {
		List<String> t1 = new LinkedList<>();
//		t1.add("hi");
//		t1.add("hello");
//		t1.add("wor");
		t1.add("");
		EncodeAndDecodeStrings t = new EncodeAndDecodeStrings();
		String s1 = t.encode(t1);
		System.out.println(s1);
		List<String> l1 = t.decode(s1);
		System.out.println(l1);
	}

}
