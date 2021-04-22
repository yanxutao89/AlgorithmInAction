package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*You are given an array A of strings.

Two strings S and T are special-equivalent if after any number of moves, S == T.

A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].

Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.

Return the number of groups of special-equivalent strings from A.



Example 1:

Input: ["a","b","c","a","c","c"]
Output: 3
Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
Example 2:

Input: ["aa","bb","ab","ba"]
Output: 4
Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
Example 3:

Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
Example 4:

Input: ["abcd","cdab","adcb","cbad"]
Output: 1
Explanation: 1 group ["abcd","cdab","adcb","cbad"]


Note:

1 <= A.length <= 1000
1 <= A[i].length <= 20
All A[i] have the same length.
All A[i] consist of only lowercase letters.*/
public class GroupsOfSpecialEquivalentStrings {

	/*
	 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Groups of Special-Equivalent Strings.
	 * Memory Usage: 36 MB, less than 100.00% of Java online submissions for Groups of Special-Equivalent Strings.
	 */
	public int numSpecialEquivGroups(String[] A) {

		HashSet<String> set = new HashSet<String>();
        int result = 0;
        for(String str: A){
            if(set.add(getHashBySwap(str.toCharArray()))) {
                result++;
            }
        }
        return result;
    }

    private String getHashBySwap(char[] chars){

    	for(int i = 0; i < chars.length; i++){
            for(int j = i + 2; j < chars.length;){
                if(chars[i] > chars[j]) {
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
                j += 2;
            }
        }

        return String.valueOf(chars);
    }

	public static void main(String[] args) {

		String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};

		System.out.println(new GroupsOfSpecialEquivalentStrings().numSpecialEquivGroups(A));
	}
}
