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

	/**
	 * Runtime: 10 ms, faster than 5.31% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * Memory Usage: 40.3 MB, less than 5.01% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * @param s
	 * @return
	 */
	public String modifyString2(String s) {
		if (s.matches("^\\?+$")) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); ++i) {
				sb.append((i & 1) == 0 ? "a" : "b");
			}
			return sb.toString();
		}
		StringBuilder res = new StringBuilder();
		char[] chars = s.toCharArray();
		int offset = -1;
		int count = -1;
		for (int i = 0; i < chars.length; ++i) {
			if (chars[i] == '?') {
				offset = offset == -1 ? i : offset;
				count = count == -1 ? 1 : ++count;
			} else {
				if (offset != -1 && count != -1) {
					res.append(getStr(s, offset, count));
					offset = -1;
					count = -1;
				}
				res.append(chars[i]);
			}
		}

		if (offset != -1 && count != -1) {
			res.append(getStr(s, offset, count));
		}

		return res.toString();
	}

	private String getStr(String s, int offset, int count) {

		StringBuilder sb = new StringBuilder(count);

		if (offset == 0 && offset + count < s.length()) {
			char r = getNearbyChar(s.charAt(count));
			for (int i = 0; i < count; ++i) {
				sb.append((i & 1) == 0 ? r : 'a');
			}
			sb = sb.reverse();
		}
		else if (offset + count == s.length()) {
			char l = 'a';
			char r = getNearbyChar(s.charAt(offset == 0 ? offset : offset - 1));
			if (r == 'a') {
				l = getNearbyChar(r, 'a');
			}
			for (int i = 0; i < count; ++i) {
				sb.append((i & 1) == 0 ? r : l);
			}
		}
		else {
			if (count == 1) {
				sb.append(getNearbyChar(s.charAt(offset - 1), s.charAt(offset + count)));
			} else {
				char l;
				char r;
				if (s.charAt(offset - 1) == s.charAt(offset + count)) {
					l = getNearbyChar(s.charAt(offset - 1));
					r = getNearbyChar(l);
				} else {
					l = s.charAt(offset + count);
					r = s.charAt(offset - 1);
				}
				if (l == r) {
					r = getNearbyChar(l, r);
				}
				boolean isEven = (count & 1) == 0;
				count = isEven ? count : count - 1;
				for (int i = 0; i < count; ++i) {
					sb.append((i & 1) == 0 ? l : r);
				}
				if (!isEven) {
					sb.append(getNearbyChar(l, r));
				}
			}
		}

		return sb.toString();
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

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * Memory Usage: 38.7 MB, less than 85.26% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * @param s
	 * @return
	 */
	public String modifyString3(String s) {
		char[] arr = s.toCharArray();
		for(int i = 0, len = arr.length; i < len; ++i){
			if(arr[i] == '?') {
				for(char ch = 'a'; ch <= 'z'; ++ch){
					if(satisfies(arr, ch, i)){
						arr[i] = ch;
						break;
					}
				}
			}
		}
		return new String(arr);
	}

	public boolean satisfies(char[] arr, char ch, int index){
		return satisfiesLeft(arr, ch, index) && satisfiesRight(arr, ch, index);
	}

	public boolean satisfiesLeft(char[] arr, char ch, int index){
		if(index == 0) {
			return true;
		}
		return arr[index - 1] != ch;
	}

	public boolean satisfiesRight(char[] arr, char ch, int index){
		if(index == arr.length - 1) {
			return true;
		}
		return arr[index + 1] != ch;
	}

	/**
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * Memory Usage: 38.8 MB, less than 72.15% of Java online submissions for Replace All ?'s to Avoid Consecutive Repeating Characters.
	 * @param s
	 * @return
	 */
	public String modifyString4(String s) {
		if (s.length() == 1) {
			return s.charAt(0) == '?' ? "a" : s;
		}
		char[] arr = s.toCharArray();
		for(int i = 0, len = arr.length; i < len; ++i){
			if(arr[i] == '?') {
				if (i == 0) {
					arr[i] = arr[1] == 'a' ? 'b' : 'a';
				}
				else if (i == len - 1) {
					arr[i] = arr[len - 2] == 'a' ? 'b' : 'a';
				}
				else {
					for(char ch = 'a'; ch <= 'c'; ++ch){
						if(ch != arr[i - 1] && ch != arr[i + 1]){
							arr[i] = ch;
							break;
						}
					}
				}
			}
		}
		return new String(arr);

	}

	public static void main(String[] args) {
		String s = "?";
		System.out.println(new ReplaceAllToAvoidConsecutiveRepeatingCharacters().modifyString(s));
		System.out.println(new ReplaceAllToAvoidConsecutiveRepeatingCharacters().modifyString2(s));
		System.out.println(new ReplaceAllToAvoidConsecutiveRepeatingCharacters().modifyString3(s));
		System.out.println(new ReplaceAllToAvoidConsecutiveRepeatingCharacters().modifyString4(s));
	}

}
