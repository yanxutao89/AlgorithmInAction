package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/
public class SortCharactersByFrequency {

	/*
	 * Runtime: 54 ms, faster than 9.29% of Java online submissions for Sort Characters By Frequency.
	 * Memory Usage: 39.4 MB, less than 66.67% of Java online submissions for Sort Characters By Frequency.
	 */
	public String frequencySort(String s) {

		Map<Character, Integer> map = new HashMap<>();
		Character chars[] = new Character[s.length()];

		for (int i = 0; i < s.length(); i++) {
			chars[i] = s.charAt(i);
		}

		for (char c : chars) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		Arrays.sort(chars, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				int v1 = map.get(o1);
				int v2 = map.get(o2);
				if (v1 == v2) {
					return o1 - o2;
				}
				return v2 - v1;
			}
		});

		StringBuilder sb = new StringBuilder(chars.length);
		for (char c : chars) {
			sb.append(c);
		}

		return sb.toString();
    }

	public static void main(String[] args) {

		String s = "tree";

		System.out.println(new SortCharactersByFrequency().frequencySort(s));
	}
}
