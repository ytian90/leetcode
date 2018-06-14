package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 * @author ytian
 *
 */
public class EncodeAndDecodeTinyURL {

    Map<String, String> tinyUrlMap = new HashMap<>();
    Map<String, String> longUrlMap = new HashMap<>();
    static String HOST = "http://tinyurl.com/";

    public String encode(String longUrl) {
        if (longUrlMap.containsKey(longUrl))
            return longUrlMap.get(longUrl);
        String tinyUrl = HOST + (longUrl.hashCode() + System.nanoTime());
        tinyUrlMap.put(tinyUrl, longUrl);
        longUrlMap.put(longUrl, tinyUrl);
        return tinyUrl;
    }

    public String decode(String shortUrl) {
        return tinyUrlMap.get(shortUrl);
    }

	List<String> urls = new ArrayList<>();
	
	// Encodes a URL to a shortened URL.
    public String encode0(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode0(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
