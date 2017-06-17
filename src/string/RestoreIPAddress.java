package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore IP Address
 * @author yutian
 * @since Aug 21, 2015
 */
public class RestoreIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> list = new ArrayList<>();
		dfs(s, 0, new StringBuilder(), list);
		return list;
	}

	private void dfs(String s, int numPtr, StringBuilder path,
			List<String> list) {
		if (numPtr == 3) {
			if (isValidIp(s)) list.add(path.toString() + s);
		} else {
			int len = path.length();
			for (int i = 1; i <= 3 && i <= s.length(); i++) {
				String num = s.substring(0, i);
				if (isValidIp(num)) {
					dfs(s.substring(i), numPtr + 1, path.append(num).append('.'), list);
				}
				path.delete(len, path.length());
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
