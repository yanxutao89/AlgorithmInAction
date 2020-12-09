package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.



Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]


Note:

1 <= text.length <= 1000
text consists of space separated words, where each word consists of lowercase English letters.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.*/
public class OccurrencesAfterBigram {

	/*
	 * Runtime: 1 ms, faster than 95.81% of Java online submissions for Occurrences After Bigram.
	 * Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Occurrences After Bigram.
	 */
	public String[] findOcurrences(String text, String first, String second) {

		List<String> list = new ArrayList<String>();
		String[] strings = text.split(" ");

		for(int i = 0; i < strings.length - 2; i++) {

			if(strings[i].equals(first) && strings[i + 1].equals(second)) {

				list.add(strings[i + 2]);
			}
		}

		String[] res = new String[list.size()];
		list.toArray(res);

		return res;
    }

	public static void main(String[] args) {

		String text = "alice is aa good girl she is a good student";
		String first = "a";
		String second = "good";

		System.out.println(Arrays.toString(new OccurrencesAfterBigram().findOcurrences(text, first, second)));
	}
}
