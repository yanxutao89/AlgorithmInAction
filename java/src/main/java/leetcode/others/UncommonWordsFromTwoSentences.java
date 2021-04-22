package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/*We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words.

You may return the list in any order.



Example 1:

Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: A = "apple apple", B = "banana"
Output: ["banana"]


Note:

0 <= A.length <= 200
0 <= B.length <= 200
A and B both contain only spaces and lowercase letters.*/
public class UncommonWordsFromTwoSentences {

	/*
	 * Runtime: 2 ms, faster than 99.94% of Java online submissions for Uncommon Words from Two Sentences.
	 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Uncommon Words from Two Sentences.
	 */
	 public String[] uncommonFromSentences(String A, String B) {

		 List<String> list = new ArrayList<String>();
		 String string = A + " " + B;
		 Set<String> set = new HashSet<String>();
		 String[] arr = string.split(" ");

		 for(String s : arr) {

			 if(!set.add(s)) {

				 list.add(s);
			 }
		 }

		 List<String> list2 = new ArrayList<String>();
		 for(String s : arr) {

			 if(!list.contains(s)) {

				 list2.add(s);
			 }
		 }

		 String[] res = new String[list2.size()];
		 return list2.toArray(res);
	 }

	 public static void main(String[] args) {

		 String A = "this apple is sweet";
		 String B = "this apple is sour";

		 System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences().uncommonFromSentences(A, B)));
	 }
}
