package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2020/10/17 14:30
 */
public class ReverseVowelsOfAString {

	private static final List<Character> VOWELS = Arrays.asList(new Character[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'});

	/**
	 * Runtime: 14 ms, faster than 16.83% of Java online submissions for Reverse Vowels of a String.
	 * Memory Usage: 40 MB, less than 5.27% of Java online submissions for Reverse Vowels of a String.
	 * @param s
	 * @return
	 */
	public String reverseVowels(String s) {

		char[] chars = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		int length = chars.length;
		for (int i = 0; i < length; ++i) {
			char c = chars[i];
			if (VOWELS.contains(c)) {
				stack.add(c);
			} else {
				continue;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			char c = chars[i];
			if (VOWELS.contains(c)) {
				sb.append(stack.pop());
			} else {
				sb.append(c);
			}
		}

		return sb.toString();

	}

	/**
	 * Runtime: 7 ms, faster than 36.94% of Java online submissions for Reverse Vowels of a String.
	 * Memory Usage: 39 MB, less than 5.27% of Java online submissions for Reverse Vowels of a String.
	 * @param s
	 * @return
	 */
	public String reverseVowels2(String s) {

		char[] chars = s.toCharArray();
		int l = -1;
		int r = s.length();

		while (true) {
			l = findVowel(chars, l, 0);
			r = findVowel(chars, r, 1);
			if (-1 != l && -1 != r && l <= r) {
				char c = chars[l];
				chars[l] = chars[r];
				chars[r] = c;
			} else {
				break;
			}
		}

		return new String(chars);

	}

	private int findVowel(char[] chars, int index, int type) {
		if (0 == type) {
			for (int i = index + 1; i < chars.length; ++i) {
				if (VOWELS.contains(chars[i])) {
					return i;
				}
			}
		}
		if (1 == type) {
			for (int i = index - 1; i > -1; --i) {
				if (VOWELS.contains(chars[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		String s = "hello";
		System.out.println(new ReverseVowelsOfAString().reverseVowels(s));
		System.out.println(new ReverseVowelsOfAString().reverseVowels2(s));
	}
}
