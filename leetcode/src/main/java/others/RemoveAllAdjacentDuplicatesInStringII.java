package others;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.



Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"


Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.*/
public class RemoveAllAdjacentDuplicatesInStringII {

	/*
	 * Runtime: 733 ms, faster than 5.03% of Java online submissions for Remove All Adjacent Duplicates in String II.
	 * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates in String II.
	 */
	public String removeDuplicates(String s, int k) {

		while(!getIndex(s, k).isEmpty()) {

			List<String> list = getIndex(s, k);

			for(int i = 0; i < list.size(); i++) {

				s = s.replace(list.get(i), "");
			}
		}

		return s;
	}

	private List<String> getIndex(String s, int k) {

		List<String> list = new ArrayList<String>();

		if(s.length() < k) {
			return list;
		}

		int count = 0;
		outer: for(int i = 0; i < s.length() - k + 1; i++) {

			count = 1;
			for(int j = i + 1; j < i + k; j++) {
				if(s.charAt(i) == s.charAt(j)) {
					count++;
				} else {
					continue outer;
				}
			}

			if(count == k) {

				StringBuilder sb = new StringBuilder();
				for(int l = 0; l < k; l++) {
					sb.append(s.charAt(i));
				}
				list.add(sb.toString());
				i += k;
			}
		}

		return list;
	}

	public static void main(String[] args) {

		String s = "eeeo";
		int k = 3;

		System.out.println(new RemoveAllAdjacentDuplicatesInStringII().removeDuplicates(s, k));
	}
}
