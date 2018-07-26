package bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 751. IP to CIDR
 * @author ytian
 *
 */
public class IPtoCIDR {
	public static List<String> ipToCIDR(String ip, int n) {
		List<String> res = new ArrayList<>();
		long x = 0;
		String[] ips = ip.split("\\.");
		for (int i = 0; i < ips.length; i++) {
			x = Integer.parseInt(ips[i]) + x * 256;
		}
		while (n > 0) {
			long step = x & -x;
			while (step > n)
				step /= 2;
			res.add(longToIP(x, (int) step));
			x += step;
			n -= step;
		}
		return res;
	}

	private static String longToIP(long x, int step) {
		int[] res = new int[4];
		res[0] = (int) (x & 255);
		x >>= 8;
		res[1] = (int) (x & 255);
		x >>= 8;
		res[2] = (int) (x & 255);
		x >>= 8;
		res[3] = (int) x;
		int len = 33;
		while (step > 0) {
			len--;
			step /= 2;
		}
		return res[3] + "." + res[2] + "." + res[1] + "." + res[0] + "/" + len;
	}
	
	 public static void main(String[] args) {
		System.out.println(ipToCIDR("255.0.0.7", 10));
	}
}
