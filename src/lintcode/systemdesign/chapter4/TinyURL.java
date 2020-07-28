package lintcode.systemdesign.chapter4;

import java.util.*;

/**
 * 232. Tiny URL
 */
public class TinyURL {
    Map<String, String> shortToLongMap = new HashMap<>();
    Map<String, String> longToShortMap = new HashMap<>();
    static String BASE_HOST = "http://tiny.url/";
    static String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static int DIGIT = 6;
    static Random rand = new Random();

    /*
     * @param url: a long url
     * @return: a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        // write your code here
        if (longToShortMap.containsKey(url)) {
            return BASE_HOST + longToShortMap.get(url);
        }
        String key;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < DIGIT; i++) {
                sb.append(CHAR_SET.charAt(rand.nextInt(CHAR_SET.length())));
            }
            key = sb.toString();
        } while (shortToLongMap.containsKey(key));
        shortToLongMap.put(key, url);
        longToShortMap.put(url, key);
        return BASE_HOST + key;
    }

    /*
     * @param url: a short url starts with http://tiny.url/
     * @return: a long url
     */
    public String shortToLong(String url) {
        // write your code here
        return shortToLongMap.get(url.replace(BASE_HOST, ""));
    }
}
