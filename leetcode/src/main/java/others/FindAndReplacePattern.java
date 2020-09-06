package others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*You have a list of words and a pattern, and you want to know which words in words matches the pattern.
A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
Return a list of the words in words that match the given pattern.
You may return the answer in any order.

Example 1:
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.

Note:
1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20*/
public class FindAndReplacePattern {

	/*
	 * Runtime: 2 ms, faster than 80.87% of Java online submissions for Find and Replace Pattern.
	 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Find and Replace Pattern.
	 */
	 public static List<String> findAndReplacePattern(String[] words, String pattern) {

		 List<String> list = new ArrayList<String>();

		 for(String word : words) {

			 if(isMatch(word, pattern)) {
				list.add(word);
			 }
		 }

		 return list;
	 }

	 private static boolean isMatch(String s1, String s2) {

		 Set<String> set = new HashSet<String>();

		 for(int i = 0; i < s1.length(); i++) {

			 set.add(s2.charAt(i) + "" + s1.charAt(i));
		 }

		 String[] strings = new String[set.size()];
		 set.toArray(strings);

		 for(int i = 0; i < strings.length - 1; i++) {

			 for(int j = i + 1; j < strings.length; j++) {

				 if(strings[i].charAt(0) == strings[j].charAt(0)) {

					 return false;
				 }

				 if(strings[i].charAt(1) == strings[j].charAt(1)) {

					 return false;
				 }
			 }
		 }

		 return true;
	 }

	/*
	 * Runtime: 4 ms, faster than 6.11% of Java online submissions for Find and Replace Pattern.
	 * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Find and Replace Pattern.
	 */
	 public static List<String> findAndReplacePattern2(String[] words, String pattern) {

		 List<String> list = new ArrayList<String>();

		 for(String word : words) {

			 if(isMatch2(word, pattern)) {
				list.add(word);
			 }
		 }

		 return list;
	 }

	 private static boolean isMatch2(String s1, String s2) {

		 Set<String> set = new HashSet<String>();

		 for(int i = 0; i < s1.length(); i++) {

			 set.add(s2.charAt(i) + "-" + s1.charAt(i));
		 }

		 String[] strings = new String[set.size()];
		 set.toArray(strings);
		 set.clear();

		 for(int i = 0; i < strings.length; i++) {

			 set.add(strings[i].charAt(0) + "");
			 set.add(strings[i].charAt(1) + strings[i].charAt(2) + "");
		 }

		 if(set.size() != strings.length * 2) {

			 return false;
		 }

		 return true;
	 }

	 public static  void main(String[] args) {

		 String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		 String pattern = "abb";

		 System.out.println(findAndReplacePattern2(words, pattern));
	 }
}
