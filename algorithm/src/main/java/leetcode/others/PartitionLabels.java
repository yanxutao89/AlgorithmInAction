package others;

import java.util.ArrayList;
import java.util.List;

/*A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.*/
public class PartitionLabels {


	/*
	 * Runtime: 2 ms, faster than 99.51% of Java online submissions for Partition Labels.
	 * Memory Usage: 36 MB, less than 96.10% of Java online submissions for Partition Labels.
	 */
	public static List<Integer> partitionLabels(String S) {

		List<Integer> list = new ArrayList<Integer>();

		int[] last = new int[26];

        for(int i = 0; i < S.length(); i++){

            last[S.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < S.length(); i++){

            int tempLast = last[S.charAt(i) - 'a'];
            for(int j = i + 1; j < tempLast; j++){
                if(last[S.charAt(j) - 'a'] > tempLast){

                    tempLast = last[S.charAt(j) - 'a'];
                }
            }

            int segSize = tempLast - i + 1;
            list.add(segSize);
            i = tempLast;
        }

		return list;

	}

	public static void main(String[] args) {

		String S = "ababcbacadefegdehijhklij";

		System.out.println(partitionLabels(S));
	}
}
