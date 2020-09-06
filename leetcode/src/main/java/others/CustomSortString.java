package others;

/*S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input:
S = "cba"
T = "abcd"
Output: "cbad"
Explanation:
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.


Note:

S has length at most 26, and no character is repeated in S.
T has length at most 200.
S and T consist of lowercase letters only.*/
public class CustomSortString {

	/*
	 * Runtime: 5 ms, faster than 14.63% of Java online submissions for Custom Sort String.
	 * Memory Usage: 36.1 MB, less than 42.42% of Java online submissions for Custom Sort String.
	 */
	public String customSortString(String S, String T) {

		StringBuilder sb = new StringBuilder();
		for(char c : S.toCharArray()) {

			int count = count(T, c);
			if(count > 0) {
				for(int i = 0; i < count; i++) {

					sb.append(c);
				}
				T = T.replaceAll(c + "", "");
			}
		}
		return sb.append(T).toString();
    }

	private int count(String T, char c) {

		int count = 0;
		for(char ch : T.toCharArray()) {

			if(ch == c) {

				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {

		String S = "cba";
		String T = "abcd";

		System.out.println(new CustomSortString().customSortString(S, T));
	}
}
