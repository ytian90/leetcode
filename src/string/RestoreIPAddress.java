package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Address
 * @author yutian
 * @since Aug 21, 2015
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		helper(s, 0, new StringBuilder(), res);
		return res;
	}

	private void helper(String s, int pos, StringBuilder sb, List<String> list) {
		if (pos == 3) {
			if (isValidIp(s)) list.add(sb.toString() + s);
		} else {
			int len = sb.length();
			for (int i = 1; i <= 3 && i <= s.length(); i++) {
				String num = s.substring(0, i);
				if (isValidIp(num)) {
					helper(s.substring(i), pos + 1, sb.append(num).append('.'), list);
				}
				sb.delete(len, sb.length());
			}
		}
	}

	private boolean isValidIp(String s) {
		if (s.length() == 1 || s.length() >= 1 && s.length() <= 3 && !s.startsWith("0")) {
			int num = Integer.parseInt(s);
			if (num >= 0 && num <= 255) return true;
		}
		return false;
	}
}
