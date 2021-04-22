package others;

/**
 * Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.



Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"


Constraints:

1 <= s.length <= 1000
s[i] only contains digits letters ('0'-'9') and '#' letter.
s will be valid string such that mapping is always possible.
 * @author Administrator
 *
 */
public class DecryptStringFromAlphabetToIntegerMapping {

	/**
	 * Runtime: 1 ms, faster than 76.42% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
	 * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
	 * @param s
	 * @return
	 */
    public String freqAlphabets(String s) {

    	StringBuffer sb = new StringBuffer();
    	char[] arr = s.toCharArray();
    	for (int i = arr.length - 1; i > -1;) {
    		char c = arr[i];
    		if (c == '#') {
    			int parseInt = Integer.parseInt(String.valueOf(arr[i - 2]) + String.valueOf(arr[i - 1]));
    			parseInt += 96;
    			sb.append((char)parseInt);
    			i -= 3;
    		} else {
    			int parseInt = Integer.parseInt(String.valueOf(c));
    			parseInt += 96;
    			sb.append((char)parseInt);
    			i -= 1;
			}
    	}

    	return sb.reverse().toString();
    }

    public static void main(String[] args) {
		String s = "10#11#12";
		System.out.println(new DecryptStringFromAlphabetToIntegerMapping().freqAlphabets(s));
	}
}
