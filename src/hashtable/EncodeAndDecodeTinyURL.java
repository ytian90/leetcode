package hashtable;

import java.util.*;

/**
 * 535. Encode and Decode TinyURL
 * @author ytian
 *
 */
public class EncodeAndDecodeTinyURL {

    Map<String, String> tinyUrlMap = new HashMap<>();
    Map<String, String> longUrlMap = new HashMap<>();
    Random rand = new Random();
    static String HOST = "https://tinyurl.com/";
    static int pathLength = 6;

    public String encode(String longUrl) {
        if (longUrlMap.containsKey(longUrl)) {
            return HOST + longUrlMap.get(longUrl);
        }
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String key = null;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pathLength; i++) {
                sb.append(charSet.charAt(rand.nextInt(62)));
            }
            key = sb.toString();
        } while (tinyUrlMap.containsKey(key));
        tinyUrlMap.put(key, longUrl);
        longUrlMap.put(longUrl, key);
        return HOST + key;
    }

    public String decode(String shortUrl) {
        shortUrl = shortUrl.replace(HOST, "");
        if (tinyUrlMap.containsKey(shortUrl)) {
            return tinyUrlMap.get(shortUrl);
        }
        throw new IllegalArgumentException("Invalid shortUrl");
    }

	public static void main(String[] args) {
        EncodeAndDecodeTinyURL obj = new EncodeAndDecodeTinyURL();
        String output = obj.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(output);
        System.out.println(obj.decode(output));

	}

}
