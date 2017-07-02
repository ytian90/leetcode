package hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * 535. Encode and Decode TinyURL
 * @author ytian
 *
 */
public class EncodeAndDecodeTinyURL {
	
	List<String> urls = new ArrayList<>();
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        return String.valueOf(urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        return (index < urls.size()) ? urls.get(index) : "";
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
