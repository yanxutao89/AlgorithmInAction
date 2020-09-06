package others;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.



Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation:
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation:
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.


Note:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
All strings contain lowercase English letters only.*/
public class FindWordsThatCanBeFormedByCharacters {

	/*
	 * Runtime: 5 ms, faster than 79.51% of Java online submissions for Find Words That Can Be Formed by Characters.
	 * Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Find Words That Can Be Formed by Characters.
	 */
	public int countCharacters(String[] words, String chars) {

		int sum = 0;

		for(String word : words) {

			if(isGood(word, chars)) {

				sum += word.length();
			}
		}

		return sum;
	}

	private boolean isGood(String word, String chars) {

		Map<String, String> map = new HashMap<String, String>();

		int index = Integer.MIN_VALUE;
		if(word.length() < chars.length()) {
			for(char c : word.toCharArray()) {

				if(count(word, c) > count(chars, c)) {

					return false;
				}
			}
		} else {

			return false;
		}

		return true;
	}

	private int count(String string, char c) {

		int count = 0;
		for(char ch : string.toCharArray()) {

			if(ch == c) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		String[] words = {"skwgxuuuumkfurejmqrbipvlavdrozjyxhagbwetabjwevfsegqfpllgafm","ufvpzzgpswnk","tcouxmlrnfyoxvkeglchhryykmdvgvdxpookbtiyhuthoqsnqbowewpfgbcy","qwpttmxzazkkfqqtrnkaejifligdvgnyvtmppjbkeuqryxzqyegttvhzolpztvigxygzvsppurijaekb","vbtvbheurzbglzljczmziitkbmtoybiwhoyfrsxvfveaxchebjdzdnnispzwbrgrbcdaistps"};
		String chars = 	"avyteswqppomeojxoybotzriuvxolmllevluauwb";

		System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(words, chars));
	}
}
