package others;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.*/

public class EncodeAndDecodeTinyURL {


	/*
	 * Runtime: 9 ms, faster than 35.26% of Java online submissions for Encode and Decode TinyURL.
	 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Encode and Decode TinyURL.
	 */
	static Map<Integer, Character> map = new HashMap<Integer, Character>();
	 // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {

    	StringBuilder sb = new StringBuilder();

    	for(int i = 0; i < longUrl.length(); i++) {

    		if(map.containsValue(longUrl.charAt(i))) {

    			sb.append(longUrl.charAt(i));
    		}
    		map.put(i, longUrl.charAt(i));
    	}

    	return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {

    	StringBuilder sb = new StringBuilder();
    	for(Map.Entry<Integer, Character> entry : map.entrySet()) {

    		sb.append(entry.getValue());
    	}

    	return sb.toString();
    }

    private static final Base64.Encoder ENCODER = Base64.getEncoder();
    private final static Map<String, String> urlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public static String encode2(String longUrl) {
        String randomAlpha = base64(longUrl);
        urlMap.put(randomAlpha, longUrl);
        return randomAlpha;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode2(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    private static String base64(String url) {
        try {
            return ENCODER.encodeToString(url.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

	/*
	 * Runtime: 54 ms, faster than 5.38% of Java online submissions for Encode and Decode TinyURL.
	 * Memory Usage: 37.3 MB, less than 68.00% of Java online submissions for Encode and Decode TinyURL.
	 */
    static Map<String, String> map3 = new HashMap<String, String>();
	 // Encodes a URL to a shortened URL.
   public static String encode3(String longUrl) {

   	StringBuilder sb = new StringBuilder();

   	for(int i = 0; i < longUrl.length(); i++) {

   		if(count(longUrl, longUrl.charAt(i)) > 3) {

   	   		sb.append(longUrl.charAt(i));
   			longUrl.replaceAll(String.valueOf(longUrl.charAt(i)), "");
   		}
   	}

   	map3.put(sb.toString(), longUrl);
   	return sb.toString();
   }

   // Decodes a shortened URL to its original URL.
   public static String decode3(String shortUrl) {

	   return map3.get(shortUrl);
   }

   private static int count(String string, Character character) {

	   int count = 0;
	   for(Character character2 : string.toCharArray()) {

		   if(character.equals(character2)) {

			   count++;
		   }
	   }

	   return count;
   }

    public static void main(String[] args) {

    	String longUrl = "http://www.leetcode.com/faq/?id=10";

    	System.out.println(encode3(longUrl));
    	System.out.println(decode3(encode3(longUrl)));
    }

}
