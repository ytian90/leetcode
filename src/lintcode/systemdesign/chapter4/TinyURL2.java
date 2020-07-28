package lintcode.systemdesign.chapter4;

import java.util.*;

/**
 * 522. Tiny URL 2
 */
public class TinyURL2 {
    Map<String, String> shortToLongMap = new HashMap<>();
    Map<String, String> longToShortMap = new HashMap<>();
    static String BASE_HOST = "http://tiny.url/";
    static String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static int DIGIT = 6;
    static Random rand = new Random();

    /*
     * @param long_url: a long url
     * @param key: a short key
     * @return: a short url starts with http://tiny.url/
     */
    public String createCustom(String long_url, String key) {
        // write your code here
        if (longToShortMap.containsKey(long_url)) {
            if (longToShortMap.get(long_url).equals(key)) {
                return BASE_HOST + key;
            } else {
                return "error";
            }
        }
        if (shortToLongMap.containsKey(key)) {
            return "error";
        }
        longToShortMap.put(long_url, key);
        shortToLongMap.put(key, long_url);
        return BASE_HOST + key;
    }

    /*
     * @param long_url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String long_url) {
        // write your code here
        if (longToShortMap.containsKey(long_url)) {
            return BASE_HOST + longToShortMap.get(long_url);
        }
        String key;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < DIGIT; i++) {
                sb.append(CHAR_SET.charAt(rand.nextInt(CHAR_SET.length())));
            }
            key = sb.toString();
        } while (shortToLongMap.containsKey(key));
        shortToLongMap.put(key, long_url);
        longToShortMap.put(long_url, key);
        return BASE_HOST + key;
    }

    /*
     * @param short_url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String short_url) {
        // write your code here
        return shortToLongMap.get(short_url.replace(BASE_HOST, ""));
    }
}
