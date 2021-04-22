package leetcode.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string word that consists of digits and lowercase English letters.
 *
 * You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".
 *
 * Return the number of different integers after performing the replacement operations on word.
 *
 * Two integers are considered different if their decimal representations without any leading zeros are different.
 *
 *
 *
 * Example 1:
 *
 * Input: word = "a123bc34d8ef34"
 * Output: 3
 * Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.
 * Example 2:
 *
 * Input: word = "leet1234code234"
 * Output: 2
 * Example 3:
 *
 * Input: word = "a1b01c001"
 * Output: 1
 * Explanation: The three integers "1", "01", and "001" all represent the same integer because
 * the leading zeros are ignored when comparing their decimal values.
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 1000
 * word consists of digits and lowercase English letters.
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2021/04/09 14:08
 */
public class NumberOfDifferentIntegersInAString {

	/**
	 * Runtime: 11 ms, faster than 22.59% of Java online submissions for Number of Different Integers in a String.
	 * Memory Usage: 39 MB, less than 46.88% of Java online submissions for Number of Different Integers in a String.
	 * @param word
	 * @return
	 */
	public int numDifferentIntegers(String word) {
		word = word.replaceAll("[a-z]+", " ");
		String[] split = word.split("\\s+");
		Set<String> set = new HashSet<>();
		for (String str : split) {
			if (!"".equals(str)) {
				str = str.replaceAll("^0*", "");
				set.add(str);
			}
		}
		return set.size();
	}

	/**
	 * Runtime: 7 ms, faster than 37.75% of Java online submissions for Number of Different Integers in a String.
	 * Memory Usage: 38.9 MB, less than 52.34% of Java online submissions for Number of Different Integers in a String.
	 * @param word
	 * @return
	 */
	public int numDifferentIntegers2(String word) {
		Set<String> set = new HashSet<>();
		char[] chars = word.toCharArray();
		StringBuilder sb = null;
		for (char c : chars) {
			if (c >= 'a' && c <= 'z') {
				if (sb != null) {
					set.add(sb.toString().replaceAll("^0*", ""));
					sb = null;
				}
			}
			else {
				if (sb == null) {
					sb = new StringBuilder();
				}
				if (sb != null) {
					sb.append(c);
				}
			}
		}
		if (sb != null) {
			set.add(sb.toString().replaceAll("^0*", ""));
		}
		return set.size();
	}

	public static void main(String[] args) {
		String word = "leet1234code234";
		System.out.println(new NumberOfDifferentIntegersInAString().numDifferentIntegers(word));
		System.out.println(new NumberOfDifferentIntegersInAString().numDifferentIntegers2(word));
	}
}
