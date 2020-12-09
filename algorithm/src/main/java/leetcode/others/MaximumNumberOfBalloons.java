package others;

/*Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.*/
public class MaximumNumberOfBalloons {

	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Number of Balloons.
	 * Memory Usage: 38 MB, less than 100.00% of Java online submissions for Maximum Number of Balloons.
	 */
	 public int maxNumberOfBalloons(String text) {

		 int[] letters = new int[26];

		 for(char c : text.toCharArray()) {

			 letters[c - 'a']++;
		 }

		 return Math.min(letters['b' - 'a'],
				 Math.min(letters['a' - 'a'],
				 Math.min((int)letters['l' - 'a'] / 2,
				 Math.min((int)letters['o' - 'a'] / 2, letters['n' - 'a']))));
	 }

	 public static void main(String[] args) {

		 String text = "loonbalxballpon";

		 System.out.println(new MaximumNumberOfBalloons().maxNumberOfBalloons(text));
	 }
}
