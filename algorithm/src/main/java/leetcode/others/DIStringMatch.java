package others;

import java.util.Arrays;

/*Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]


Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]


Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".*/
public class DIStringMatch {

	/*
	 * Runtime: 2 ms, faster than 95.21% of Java online submissions for DI String Match.
	 * Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for DI String Match.
	 */
	public int[] diStringMatch(String S) {

		if (S == null || S.length() == 0) {

            return new int[0];
		}

        int[] result = new int[S.length() + 1];

        int i = 0, j = S.length();

        for (int k = 0; k < S.length(); k++) {
            char c = S.charAt(k);
            if (c == 'I') {

                result[k] = i++;
            } else {

            	result[k] = j--;
            }

        }
        result[S.length()] = i;

        return result;
    }

	public static void main(String[] args) {

		String S = "IDID";

		System.out.println(Arrays.toString(new DIStringMatch().diStringMatch(S)));
	}
}
