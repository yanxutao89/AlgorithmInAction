package leetcode.strings;

/**
 * Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
 *
 * It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
 *
 * Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "?zs"
 * Output: "azs"
 * Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
 * Example 2:
 *
 * Input: s = "ubv?w"
 * Output: "ubvaw"
 * Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ubvvw" and "ubvww".
 * Example 3:
 *
 * Input: s = "j?qg??b"
 * Output: "jaqgacb"
 * Example 4:
 *
 * Input: s = "??yw?ipkj?"
 * Output: "acywaipkja"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 100
 * s contains only lower case English letters and '?'.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/09 16:02
 */
public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {

	/**
	 * Runtime: 15 ms, faster than 5.44% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * Memory Usage: 40.5 MB, less than 5.02% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * @param s
	 * @return
	 */
	public String modifyString(String s) {
		int len = s.length();
		int index = s.indexOf("?");
		if (len == 1) {
			return index == -1 ? s : "a";
		}
		if (s.matches("^\\?+$")) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; ++i) {
				sb.append((i & 1) == 0 ? "a" : "b");
			}
			return sb.toString();
		}
		while (index != -1) {
			if (index == 0) {
				s = s.replaceFirst("\\?", getNearbyChar(s.charAt(index + 1)) + "");
			}
			else if (index == len - 1) {
				s = s.replaceFirst("\\?", getNearbyChar(s.charAt(index - 1)) + "");
			}
			else {
				s = s.replaceFirst("\\?", getNearbyChar(s.charAt(index - 1), s.charAt(index + 1)) + "");
			}
			index = s.indexOf("?");
		}
		return s;
	}

	private char getNearbyChar(char c) {
		if (c == 'a') {
			return 'z';
		}
		if (c == 'z') {
			return 'a';
		}
		if (c == '?') {
			return 'a';
		}
		return (char)((int)c + 1);
	}

	private char getNearbyChar(char c1, char c2) {
		if (c1 == c2) {
			return getNearbyChar(c1);
		}
		if (c1 == '?' && c2 != '?') {
			return getNearbyChar(c2);
		}
		if (c2 == '?' && c1 != '?') {
			return getNearbyChar(c1);
		}
		int c1int = c1;
		int c2int = c2;
		if (Math.abs(c1 - c2) == 1) {
			return c1int > c2int ? getNearbyChar(c1) : getNearbyChar(c2);
		}
		int res = (c1int + c2int) / 2;
		if (res < 97) {
			res |= 32;
		}
		return (char) (res);
	}

	public static void main(String[] args) {
		String s = "h???";
		System.out.println(new ReplaceAllToAvoidConsecutiveRepeatingCharacters().modifyString(s));
	}

}
