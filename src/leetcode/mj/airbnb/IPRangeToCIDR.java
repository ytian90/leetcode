package leetcode.mj.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * 10. IP Range to CIDR
 * https://www.youtube.com/watch?v=PnApdHjU8sg
 * https://www.youtube.com/watch?v=ls1mMyfnaC0
 */
public class IPRangeToCIDR {

    private static long ipToLong(String strIP) {
        long[] ip = new long[4];
        String[] ipSec = strIP.split("\\.");
        for (int k = 0; k < 4; k++) {
            ip[k] = Long.valueOf(ipSec[k]);
        }
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }

    private static String longToIP(long longIP) {
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf(longIP >>> 24));
        sb.append(".");
        sb.append(String.valueOf((longIP & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((longIP & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf(longIP & 0X000000FF));
        return sb.toString();
    }

    public static List<String> ipRange2Cidr(String startIp, int range) {
        long start = ipToLong(startIp);
        long end = start + range - 1;
        List<String> res = new ArrayList<>();
        while (start <= end) {
            long locOfFirstOne = start & (-start);
            int currMask = 32 - (int) (Math.log(locOfFirstOne) / Math.log(2));
            double currRange = Math.log(end - start + 1) / Math.log(2);
            int currRangeMask = 32 - (int) Math.floor(currRange);
            currMask = Math.max(currMask, currRangeMask);
            String ip = longToIP(start);
            res.add(ip + "/" + currMask);
            start += Math.pow(2, (32 - currMask));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(ipRange2Cidr("1.1.1.0", 4));
        System.out.println(ipRange2Cidr("1.1.1.1", 4));
    }
}
