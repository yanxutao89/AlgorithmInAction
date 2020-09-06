package others;

import java.util.Arrays;

/*Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.



Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").


Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.*/
public class CompareStringsByFrequencyOfTheSmallestCharacter {

	/*
	 * Runtime: 11 ms, faster than 42.04% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
	 * Memory Usage: 37.9 MB, less than 100.00% of Java online submissions for Compare Strings by Frequency of the Smallest Character.
	 */
	public int[] numSmallerByFrequency(String[] queries, String[] words) {

		int[] res = new int[queries.length];

		int[] queriesInt = convert(queries);
		int[] wordsInt = convert(words);

		for(int i = 0; i < res.length; i++) {

			res[i] = count(wordsInt, queriesInt[i]);
		}

		return res;
    }

	private int count(int[] arr, int num) {

		int count = 0;
		for(int i : arr) {

			if(i > num) {
				count++;
			}
		}

		return count;
	}

	private int[] convert(String[] arr) {

		int[] res = new int[arr.length];

		for(int i = 0; i < arr.length; i++) {

			Character character = getSmallestChar(arr[i]);
			int count = 0;
			for(char c : arr[i].toCharArray()) {

				if(c == character) {

					count++;
				}
			}

			res[i] = count;
		}

		return res;
	}

	private Character getSmallestChar(String string) {

		Character character = string.charAt(0);

		for(char c : string.toCharArray()) {
			if(character - c > 0) {

				character = c;
			}
		}

		return character;

	}

	public static void main(String[] args) {

		String[] queries = {"cbd"};
		String[] words = {"zaaaz"};

		System.out.println(Arrays.toString(new CompareStringsByFrequencyOfTheSmallestCharacter().numSmallerByFrequency(queries, words)));
	}
}
