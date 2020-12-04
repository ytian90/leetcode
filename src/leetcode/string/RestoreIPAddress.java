package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Address
 * @author yutian
 * @since Aug 21, 2015
 */
public class RestoreIPAddress {
	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		helper(s, new ArrayList<>(), res);
		return res;
	}

	public static void helper(String s, List<String> list, List<String> res) {
		if (list.size() > 4 || (list.size() == 4 && s.length() > 0)) {
			return;
		}
		if (s.length() == 0) {
			if (list.size() == 4) {
				res.add(getIpAddress(list));
				return;
			}
		}
		for (int len = 1; len <= 3 && len <= s.length(); len++) {
			String num = s.substring(0, len);
			if (num.charAt(0) == '0' && num.length() > 1) {
				continue;
			}
			if (Integer.valueOf(num) <= 255) {
				list.add(num);
				helper(s.substring(len), list, res);
				list.remove(list.size() - 1);
			}
		}
	}

	public static String getIpAddress(List<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String i : list) {
			sb.append(i);
			sb.append(".");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
		System.out.println(restoreIpAddresses("010010"));
		System.out.println(restoreIpAddresses("172162541"));
	}
}
